package com.fab.inventory.dao;

import com.fab.inventory.domain.User;

public interface UserDao
{
	User findByUsername(String username);
	
}