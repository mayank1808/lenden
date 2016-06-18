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

import com.vedaan.lenden.catalog.enums.CommunityType;

/**
 * @author mayank
 *
 */
@Entity
@Table(name = "community")
public class CommunityEO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk", unique = true, nullable = false)
	private int pk;
	
	@Column(name = "communityName", length = 255, nullable = false)
	private String communityName;
	
	@Column(name = "type", length = 255, nullable = false)
	private CommunityType type;
	
	@Column(name = "city", length = 255, nullable = false)
	private String city;
	
	@Column(name = "state", length = 255, nullable = false)
	private String state;

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public CommunityType getType() {
		return type;
	}

	public void setType(CommunityType type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
