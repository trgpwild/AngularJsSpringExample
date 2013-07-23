package org.angular.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.angular.spring.entity.Role;
import org.springframework.transaction.annotation.Transactional;

public class RoleDaoJpa implements RoleDao {

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
	public List<Role> findAll() {

		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<Role> criteriaQuery = builder.createQuery(Role.class);

		Root<Role> root = criteriaQuery.from(Role.class);
		criteriaQuery.orderBy(builder.desc(root.get("date")));

		TypedQuery<Role> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}


	@Override
	@Transactional(readOnly = true)
	public Role find(Long id) {

		return this.getEntityManager().find(Role.class, id);
	}


	@Override
	@Transactional
	public Role save(Role obj) {

		return this.getEntityManager().merge(obj);
	}


	@Override
	@Transactional
	public void delete(Long id) {

		if (id == null) {
			return;
		}

		Role obj = this.find(id);
		if (obj == null) {
			return;
		}

		this.getEntityManager().remove(obj);
	}

}
