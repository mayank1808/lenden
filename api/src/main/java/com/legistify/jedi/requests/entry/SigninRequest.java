package com.legistify.jedi.requests.entry;

import java.io.Serializable;

public class SigninRequest implements Serializable {

	private static final long serialVersionUID = -7428128026647041882L;
	private String emailId;
	private String password;

	public SigninRequest() {
		super();
	}

	public SigninRequest(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
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

	@Override
	public String toString() {
		return "SigninRequest [emailId=" + emailId + ", password=" + password + "]";
	}

}
