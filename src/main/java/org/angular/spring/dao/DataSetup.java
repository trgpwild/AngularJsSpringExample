package org.angular.spring.dao;

import java.util.Date;
import java.util.HashSet;

import org.angular.spring.entity.Role;
import org.angular.spring.entity.Tag;
import org.angular.spring.entity.User;

public class DataSetup {

	private TagDao tagDao;
	private RoleDao roleDao;
	private UserDao userDao;

	public DataSetup(TagDao tagDao, RoleDao roleDao, UserDao userDao) {
		this.tagDao = tagDao;
		this.roleDao = roleDao;
		this.userDao = userDao;
	}
	
	public void setupTags() {

		long timestamp = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
		for (int i = 0; i < 10; i++) {
			Tag newsEntry = new Tag();
			newsEntry.setContent("Example tag " + i);
			newsEntry.setDate(new Date(timestamp));
			tagDao.save(newsEntry);
			timestamp += 1000 * 60 * 60;
		}
		
	}
	
	public void setupRoles() {

		Role adminRole = new Role();
		adminRole.setAuthority("admin");
		roleDao.save(adminRole);

		Role userRole = new Role();
		userRole.setAuthority("user");
		roleDao.save(userRole);
		
	}
	
	public void setupUsers() {

		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setRoles(new HashSet<Role>());
		admin.getRoles().add(roleDao.find(1l));
		admin.getRoles().add(roleDao.find(2l));
		userDao.save(admin);
		
		User user = new User();
		user.setUsername("user");
		user.setPassword("user");
		user.setRoles(new HashSet<Role>());
		user.getRoles().add(roleDao.find(2l));
		userDao.save(user);

	}

}