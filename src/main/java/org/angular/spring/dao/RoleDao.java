package org.angular.spring.dao;

import java.util.List;

import org.angular.spring.entity.Role;

public interface RoleDao {

	List<Role> findAll();
	Role find(Long id);
	Role save(Role obj);
	void delete(Long id);

}