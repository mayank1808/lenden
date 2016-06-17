package com.legistify.jedi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.legistify.jedi.handler.RequestHandler;
import com.legistify.jedi.requests.entry.SigninRequest;
import com.legistify.jedi.requests.entry.SignupRequest;
import com.legistify.jedi.responses.entry.OTPResponse;
import com.legistify.jedi.responses.entry.SigninResponse;
import com.legistify.jedi.responses.entry.SignupResponse;

@RestController
public class EntryController {

	@Autowired
	RequestHandler requestHandler;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> signup() {
		return new ResponseEntity<String>("working", HttpStatus.OK);
	}

	@RequestMapping(value = "/lawyer/signup", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request) {
		if (request != null) {
			return requestHandler.signupLawyer(request);
		}
		return new ResponseEntity<SignupResponse>(new SignupResponse(false, "Invalid request"), HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/lawyer/signin", method = RequestMethod.POST)
	public ResponseEntity<SigninResponse> lawyerSignin(@RequestBody SigninRequest request) {
		if (request != null) {
			return requestHandler.signinLawyer(request);
		}
		return new ResponseEntity<SigninResponse>(new SigninResponse(false, null, "Invalid request"),
				HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/lawyer/otp", method = RequestMethod.GET)
	public ResponseEntity<OTPResponse> resendOTP(@Param(value = "lawyerId") String lawyerId) {
		if (lawyerId != null && !lawyerId.isEmpty()) {
			return requestHandler.resendOTP(lawyerId);
		}
		return new ResponseEntity<OTPResponse>(new OTPResponse(false, "Invalid request"), HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/lawyer/otp", method = RequestMethod.POST)
	public ResponseEntity<OTPResponse> verifyOTP(@Param(value = "emailId") String emailId,
			@Param(value = "otp") int otp) {
		return requestHandler.verifyOTP(emailId, otp);
	}
}
