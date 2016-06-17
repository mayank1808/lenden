package com.legistify.jedi.responses.entry;

import java.io.Serializable;

public class OTPResponse implements Serializable {

	private static final long serialVersionUID = 4776030006729604992L;
	private boolean successful;
	private String errorMessage;

	public OTPResponse() {
		super();
	}

	public OTPResponse(boolean successful, String errorMessage) {
		super();
		this.successful = successful;
		this.errorMessage = errorMessage;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "OTPResponse [successful=" + successful + ", errorMessage=" + errorMessage + "]";
	}

}