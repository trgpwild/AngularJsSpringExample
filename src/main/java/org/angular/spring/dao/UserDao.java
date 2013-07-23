package org.angular.spring.dao;

import java.util.List;

import org.angular.spring.entity.User;

public interface UserDao {

	List<User> findAll();
	User find(Long id);
	User save(User obj);
	void delete(Long id);

}