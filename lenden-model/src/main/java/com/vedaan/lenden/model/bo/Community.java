/**
 * 
 */
package com.vedaan.lenden.model.bo;

import com.vedaan.lenden.catalog.enums.CommunityType;

/**
 * @author mayank
 *
 */
public class Community {

	private String communityName;

	private CommunityType type;

	private String city;

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
