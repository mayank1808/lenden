package com.legistify.jedi.requests.entry;

import java.io.Serializable;

public class SignupRequest implements Serializable {

	private static final long serialVersionUID = 4178781295860733399L;
	private String emailId;
	private String password;
	private long phoneNumber;

	public SignupRequest() {
		super();
	}

	public SignupRequest(String emailId, String password, long phoneNumber) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "SignupRequest [emailId=" + emailId + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}

}
