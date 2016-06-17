package com.legistify.jedi.common.bo;

import java.io.Serializable;

public class LawyerBO implements Serializable {

	private static final long serialVersionUID = -1534350567233055493L;
	private String emailId;
	private String password;
	private long phoneNumber;
	private String firstName;
	private String lastName;
	private boolean isOTPVerified;
	private boolean isLawyerVerified;
	private String barCouncilId;

	public LawyerBO() {
		super();
	}

	public LawyerBO(String emailId, String password, long phoneNumber, String firstName, String lastName,
			boolean isOTPVerified, boolean isLawyerVerified, String barCouncilId) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isOTPVerified = isOTPVerified;
		this.isLawyerVerified = isLawyerVerified;
		this.barCouncilId = barCouncilId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public boolean isOTPVerified() {
		return isOTPVerified;
	}

	public void setOTPVerified(boolean isOTPVerified) {
		this.isOTPVerified = isOTPVerified;
	}

	public boolean isLawyerVerified() {
		return isLawyerVerified;
	}

	public void setLawyerVerified(boolean isLawyerVerified) {
		this.isLawyerVerified = isLawyerVerified;
	}

	public String getBarCouncilId() {
		return barCouncilId;
	}

	public void setBarCouncilId(String barCouncilId) {
		this.barCouncilId = barCouncilId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LawyerBO [emailId=" + emailId + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", isOTPVerified=" + isOTPVerified
				+ ", isLawyerVerified=" + isLawyerVerified + ", barCouncilId=" + barCouncilId + "]";
	}

}
