package org.angular.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.angular.spring.entity.User;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoJpa implements UserDao {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {

		return this.entityManager;
	}

	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager) {

		this.entityManager = entityManager;
	}


	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {

		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.orderBy(builder.desc(root.get("date")));

		TypedQuery<User> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}


	@Override
	@Transactional(readOnly = true)
	public User find(Long id) {

		return this.getEntityManager().find(User.class, id);
	}


	@Override
	@Transactional
	public User save(User obj) {
		return this.getEntityManager().merge(obj);
	}


	@Override
	@Transactional
	public void delete(Long id) {

		if (id == null) {
			return;
		}

		User obj = this.find(id);
		if (obj == null) {
			return;
		}

		this.getEntityManager().remove(obj);
	}

}
