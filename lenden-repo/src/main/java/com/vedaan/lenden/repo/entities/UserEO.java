/**
 * 
 */
package com.vedaan.lenden.repo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author mayank
 *
 */
@Entity
@Table(name = "user")
public class UserEO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk", unique = true, nullable = false)
	private int pk;

	@Column(name = "firstName", length = 55, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 55, nullable = false)
	private String lastName;

	@Column(name = "contact", length = 10, nullable = false)
	private String contact;

	@Column(name = "emailId", length = 55, nullable = false)
	private String emailId;

	@Column(name = "password", length = 55, nullable = false)
	private String password;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "mapping_user_community", joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "community_id") )
	private List<CommunityEO> communities;

	@Column(name = "address", length = 255, nullable = false)
	private String address;

	@Column(name = "city", length = 55, nullable = false)
	private String city;

	@Column(name = "state", length = 55, nullable = false)
	private String state;

	@Column(name = "pincode", length = 11, nullable = false)
	private String pincode;

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<CommunityEO> getCommunities() {
		return communities;
	}

	public void setCommunities(List<CommunityEO> communities) {
		this.communities = communities;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
