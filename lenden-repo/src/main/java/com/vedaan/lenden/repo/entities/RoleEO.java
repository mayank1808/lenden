/**
 * 
 */
package com.vedaan.lenden.repo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mayank
 *
 */
@Entity
@Table(name = "role")
public class RoleEO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk", unique = true, nullable = false)
	private int pk;

	@Column(name = "role", length = 255, nullable = false)
	private String role;

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public RoleEO(int pk, String role) {
		super();
		this.pk = pk;
		this.role = role;
	}

	@Override
	public String toString() {
		return "RoleEO [pk=" + pk + ", role=" + role + "]";
	}

}
