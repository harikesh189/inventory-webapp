package com.fab.inventory.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fab.inventory.constant.HotelRoomType;
import com.fab.inventory.constant.HotelStarRating;
import com.fab.inventory.dao.BaseDao;
import com.fab.inventory.dao.HotelDao;
import com.fab.inventory.dao.HotelRoomDao;
import com.fab.inventory.domain.Authority;
import com.fab.inventory.domain.Hotel;
import com.fab.inventory.domain.HotelRoom;
import com.fab.inventory.domain.User;

@Service
public class LoadInitialDBService {

	@Inject
	@Named("baseDao")
	private BaseDao baseDao;

	@Inject
	@Named("hotelDao")
	private HotelDao hotelDao;

	@Inject
	@Named("hotelRoomDao")
	private HotelRoomDao hotelRoomDao;

	@Transactional
	public void loadInitialData() {

		Authority adminAuthority = new Authority();
		adminAuthority.setAuthority("ROLE_ADMIN");
		Authority userAuthority = new Authority();
		userAuthority.setAuthority("ROLE_USER");

		User user = new User();
		user.setUsername("superadmin");
		user.setPassword("superadmin");
		user.setEmailId("superadmin@gmail.com");
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.getAuthorities().add(adminAuthority);
		adminAuthority.getUsers().add(user);

		User user2 = new User();
		user2.setUsername("normaluser");
		user2.setPassword("normaluser");
		user2.setEmailId("normaluser@gmail.com");
		user2.setEnabled(true);
		user2.setAccountNonExpired(true);
		user2.setAccountNonLocked(true);
		user2.setCredentialsNonExpired(true);
		user2.getAuthorities().add(userAuthority);
		userAuthority.getUsers().add(user2);

		baseDao.persist(user);
		baseDao.persist(user2);
		baseDao.persist(adminAuthority);
		baseDao.persist(userAuthority);

		Hotel hotel1 = new Hotel();
		hotel1.setAvailableRooms(48);
		hotel1.setHotelId("HT_101");
		hotel1.setHotelName("The Lalit");
		hotel1.setHotelRating(HotelStarRating.Four);
		hotel1.setTotalRooms(50);

		Hotel hotel2 = new Hotel();
		hotel2.setAvailableRooms(29);
		hotel2.setHotelId("HT_104");
		hotel2.setHotelName("Le Meridien");
		hotel2.setHotelRating(HotelStarRating.Five);
		hotel2.setTotalRooms(30);

		HotelRoom room1 = new HotelRoom();
		room1.setHotel(hotel1);
		room1.setHotelRoomType(HotelRoomType.NORMAL);
		room1.setRoomId("RM_1002");
		room1.setCustomerDetail(user);

		HotelRoom room2 = new HotelRoom();
		room2.setHotel(hotel1);
		room2.setHotelRoomType(HotelRoomType.NORMAL);
		room2.setRoomId("RM_1004");
		room2.setCustomerDetail(user2);

		HotelRoom room3 = new HotelRoom();
		room3.setHotel(hotel2);
		room3.setHotelRoomType(HotelRoomType.LUXURY);
		room3.setRoomId("RM_1019");
		room3.setCustomerDetail(user);

		hotelDao.persist(hotel1);
		hotelDao.persist(hotel2);
		hotelRoomDao.persist(room1);
		hotelRoomDao.persist(room2);
		hotelRoomDao.persist(room3);
	}
}