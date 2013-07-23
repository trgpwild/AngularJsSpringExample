package org.angular.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.angular.spring.entity.Tag;
import org.springframework.transaction.annotation.Transactional;

public class TagDaoJpa implements TagDao {

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
	public List<Tag> findAll() {

		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<Tag> criteriaQuery = builder.createQuery(Tag.class);

		Root<Tag> root = criteriaQuery.from(Tag.class);
		criteriaQuery.orderBy(builder.desc(root.get("date")));

		TypedQuery<Tag> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}


	@Override
	@Transactional(readOnly = true)
	public Tag find(Long id) {

		return this.getEntityManager().find(Tag.class, id);
	}


	@Override
	@Transactional
	public Tag save(Tag obj) {
		return this.getEntityManager().merge(obj);
	}


	@Override
	@Transactional
	public void delete(Long id) {

		if (id == null) {
			return;
		}

		Tag obj = this.find(id);
		if (obj == null) {
			return;
		}

		this.getEntityManager().remove(obj);
	}

}
