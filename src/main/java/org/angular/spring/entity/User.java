package org.angular.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.angular.spring.JsonViews;
import org.codehaus.jackson.map.annotate.JsonView;

@Entity
@SuppressWarnings("serial")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private Boolean enabled;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="id_user"), inverseJoinColumns=@JoinColumn(name="id_role"))
	private Set<Role> roles;

	public User() {
		setEnabled(true);
	}

	@JsonView(JsonViews.Admin.class)
	public Long getId() {
		return this.id;
	}

	@JsonView(JsonViews.User.class)
	public String getUsername() {
		return username;
	}

	@JsonView(JsonViews.Admin.class)
	public String getPassword() {
		return password;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	@JsonView(JsonViews.User.class)
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return String.format("User[%s]", this.username);
	}

}