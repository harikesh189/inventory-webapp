package com.fab.inventory.service.impl;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fab.inventory.dao.UserDao;
import com.fab.inventory.domain.User;
import com.fab.inventory.domain.UserInSession;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	

	Logger logger = Logger
			.getLogger("com.fab.inventory.service.impl.CustomUserDetailsService");

	@Autowired
	@Qualifier(value = "userDao")
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails userDetails = null;
		User user = userDao.findByUsername(username);
		if (user != null) {
			boolean enabled = user.isEnabled();
			boolean accountNonExpired = user.isAccountNonExpired();
			boolean credentialsNonExpired = user.isCredentialsNonExpired();
			boolean accountNonLocked = user.isAccountNonLocked();
			if (enabled && accountNonExpired && credentialsNonExpired
					&& accountNonLocked) {
				Hibernate.initialize(user.getAuthorities());
				userDetails = new UserInSession(user.getUsername(),
						user.getPassword(), user.getEmailId(),
						user.getAuthorities());
				logger.debug("userDetails object after login :" + userDetails);
			}
		}
		return userDetails;
	}
}