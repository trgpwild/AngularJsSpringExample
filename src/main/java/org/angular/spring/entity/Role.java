package org.angular.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.angular.spring.JsonViews;
import org.codehaus.jackson.map.annotate.JsonView;

@Entity
@SuppressWarnings("serial")
public class Role implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String authority;

	public Role() {
	}

	@JsonView(JsonViews.Admin.class)
	public Long getId() {

		return this.id;
	}

	@JsonView(JsonViews.User.class)
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return String.format("Role[%s]", this.authority);
	}

}
