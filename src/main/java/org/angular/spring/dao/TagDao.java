package org.angular.spring.dao;

import java.util.List;

import org.angular.spring.entity.Tag;

public interface TagDao {

	List<Tag> findAll();
	Tag find(Long id);
	Tag save(Tag obj);
	void delete(Long id);

}