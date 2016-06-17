package com.legistify.jedi.common.dto;

import java.io.Serializable;

public class LawyerDTO implements Serializable {

	private static final long serialVersionUID = 7203503853266810741L;
	private boolean isOTPVerified;
	private boolean isLawyerVerified;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String barCouncilId;

	public LawyerDTO() {
		super();
	}

	public LawyerDTO(boolean isOTPVerified, boolean isLawyerVerified, String firstName, String lastName,
			String phoneNumber, String barCouncilId) {
		super();
		this.isOTPVerified = isOTPVerified;
		this.isLawyerVerified = isLawyerVerified;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.barCouncilId = barCouncilId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBarCouncilId() {
		return barCouncilId;
	}

	public void setBarCouncilId(String barCouncilId) {
		this.barCouncilId = barCouncilId;
	}

	@Override
	public String toString() {
		return "LawyerDTO [isOTPVerified=" + isOTPVerified + ", isLawyerVerified=" + isLawyerVerified + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", barCouncilId="
				+ barCouncilId + "]";
	}

}
