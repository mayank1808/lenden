package com.legistify.jedi.responses.entry;

import java.io.Serializable;

public class SigninResponse implements Serializable {

	private static final long serialVersionUID = 2140812496745910956L;
	private boolean signinSuccessful;
	private String lawyerId;
	private String errorMessage;

	public SigninResponse() {
		super();
	}

	public SigninResponse(boolean signinSuccessful, String lawyerId, String errorMessage) {
		super();
		this.signinSuccessful = signinSuccessful;
		this.lawyerId = lawyerId;
		this.errorMessage = errorMessage;
	}

	public boolean isSigninSuccessful() {
		return signinSuccessful;
	}

	public void setSigninSuccessful(boolean signinSuccessful) {
		this.signinSuccessful = signinSuccessful;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getLawyerId() {
		return lawyerId;
	}

	public void setLawyerId(String lawyerId) {
		this.lawyerId = lawyerId;
	}

	@Override
	public String toString() {
		return "SigninResponse [signinSuccessful=" + signinSuccessful + ", lawyerId=" + lawyerId + ", errorMessage="
				+ errorMessage + "]";
	}

}