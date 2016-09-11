package com.fab.inventory.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.fab.inventory.domain.BaseDomain;

public interface BaseDao {

	public EntityManager getEntityManager();
	
	public Session getSession();

	public void persist(BaseDomain ob);

	public BaseDomain get(Class<? extends BaseDomain> clazz, String id);
	
	public BaseDomain load(Class<? extends BaseDomain> clazz, String id);

	public BaseDomain merge(BaseDomain ob);
	
	public void update(BaseDomain ob);
	
	public void persistAll(List<BaseDomain> objectList);
}