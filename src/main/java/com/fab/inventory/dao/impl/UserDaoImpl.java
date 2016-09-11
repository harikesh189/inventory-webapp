package com.fab.inventory.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Repository;

import com.fab.inventory.dao.BaseDao;
import com.fab.inventory.dao.UserDao;
import com.fab.inventory.domain.User;

@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Inject
	@Named("baseDao")
	private BaseDao baseDao;

	public User findByUsername(String username) {

		User user = null;
		List<User> list = baseDao.getEntityManager()
				.createQuery("from Users where username=:username")
				.setParameter("username", username).getResultList();
		if (list.size() > 0) {
			user = (User) list.get(0);
		}
		return user;
	}
}