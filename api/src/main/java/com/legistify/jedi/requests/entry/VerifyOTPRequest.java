package com.legistify.jedi.requests.entry;

import java.io.Serializable;

public class VerifyOTPRequest implements Serializable {

	private static final long serialVersionUID = -5307135352446148331L;
	private String lawyerId;
	private String otp;

	public VerifyOTPRequest() {
		super();
	}

	public VerifyOTPRequest(String lawyerId, String otp) {
		super();
		this.lawyerId = lawyerId;
		this.otp = otp;
	}

	public String getLawyerId() {
		return lawyerId;
	}

	public void setLawyerId(String lawyerId) {
		this.lawyerId = lawyerId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "VerifyOTPRequest [lawyerId=" + lawyerId + ", otp=" + otp + "]";
	}

}
