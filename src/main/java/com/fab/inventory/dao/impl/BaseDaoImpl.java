package com.fab.inventory.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import com.fab.inventory.dao.BaseDao;
import com.fab.inventory.domain.BaseDomain;

@Named("baseDao")
public class BaseDaoImpl implements BaseDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Session getSession() {

		return getEntityManager().unwrap(Session.class);
	}

	@Override
	public void persist(BaseDomain ob) {
		entityManager.persist(ob);
	}

	@Override
	public BaseDomain merge(BaseDomain ob) {
		return entityManager.merge(ob);
	}

	@Override
	public BaseDomain get(Class<? extends BaseDomain> clazz, String id) {

		return entityManager.find(clazz, id);
	}

	@Override
	public BaseDomain load(Class<? extends BaseDomain> clazz, String id) {
		return (BaseDomain) getSession().load(clazz, id);
	}

	@Override
	public void persistAll(List<BaseDomain> objectList) {
		Iterator iterator = objectList.iterator();
		while (iterator.hasNext()) {
			BaseDomain object = (BaseDomain) iterator.next();
			persist(object);
		}
	}

	@Override
	public void update(BaseDomain ob) {
		getSession().update(ob);
	}
}