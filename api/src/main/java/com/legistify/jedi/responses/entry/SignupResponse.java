package com.legistify.jedi.responses.entry;

import java.io.Serializable;

public class SignupResponse implements Serializable {

	private static final long serialVersionUID = 2140812496745910956L;
	private boolean signupSuccessful;
	private String errorMessage;

	public SignupResponse() {
		super();
	}

	public SignupResponse(boolean signupSuccessful, String errorMessage) {
		super();
		this.signupSuccessful = signupSuccessful;
		this.errorMessage = errorMessage;
	}

	public boolean isSignupSuccessful() {
		return signupSuccessful;
	}

	public void setSignupSuccessful(boolean signupSuccessful) {
		this.signupSuccessful = signupSuccessful;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "SignupResponse [signupSuccessful=" + signupSuccessful + ", errorMessage=" + errorMessage + "]";
	}

}