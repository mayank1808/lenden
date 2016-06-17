package com.legistify.jedi.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.legistify.jedi.common.dto.LawyerDTO;
import com.legistify.jedi.mapper.OrikaMapper;
import com.legistify.jedi.requests.entry.SigninRequest;
import com.legistify.jedi.requests.entry.SignupRequest;
import com.legistify.jedi.responses.entry.OTPResponse;
import com.legistify.jedi.responses.entry.SigninResponse;
import com.legistify.jedi.responses.entry.SignupResponse;
import com.legistify.jedi.service.EntryService;
import com.legistify.jedi.service.LawyerService;
import com.legistify.jedi.service.exception.ServiceLayerException;

@Configuration
public class RequestHandler {

	@Autowired
	OrikaMapper mapper;

	@Autowired
	EntryService entryService;

	@Autowired
	LawyerService lawyerService;

	public ResponseEntity<SignupResponse> signupLawyer(final SignupRequest request) {

		// TODO: add validations
		try {
			boolean alreadyExist = entryService.lawyerExists(request.getEmailId());
			if (alreadyExist) {
				return new ResponseEntity<SignupResponse>(
						new SignupResponse(false, "This emailId is already signed up. Kindly signin!"), HttpStatus.OK);
			}
			boolean signupSuccessful = entryService.signupLawyer(request.getEmailId(), request.getPassword(),
					request.getPhoneNumber());
			return new ResponseEntity<SignupResponse>(new SignupResponse(signupSuccessful,
					signupSuccessful == true ? null : "Sorry, there was some error signing up. Please try again."),
					HttpStatus.OK);
		} catch (ServiceLayerException ex) {
			return new ResponseEntity<SignupResponse>(new SignupResponse(false, "Oops! Something went wrong."),
					HttpStatus.OK);
		}
	}

	public ResponseEntity<SigninResponse> signinLawyer(final SigninRequest request) {

		// TODO: add validations
		try {
			boolean alreadyExist = entryService.lawyerExists(request.getEmailId());
			if (alreadyExist) {
				String lawyerId = entryService.signinLawyer(request.getEmailId(), request.getPassword());
				return new ResponseEntity<SigninResponse>(new SigninResponse(true, lawyerId, null), HttpStatus.OK);
			} else {
				return new ResponseEntity<SigninResponse>(
						new SigninResponse(false, null, "This emailId is not yet signed up. Kindly signup!"),
						HttpStatus.OK);
			}
		} catch (ServiceLayerException ex) {
			return new ResponseEntity<SigninResponse>(new SigninResponse(false, null, "Oops! Something went wrong."),
					HttpStatus.OK);
		}
	}

	public ResponseEntity<OTPResponse> resendOTP(final String lawyerId) {
		try {
			boolean otpSentSuccessfully = entryService.resendOTP(lawyerId);
			if (otpSentSuccessfully) {
				return new ResponseEntity<OTPResponse>(new OTPResponse(true, null), HttpStatus.OK);
			} else {
				return new ResponseEntity<OTPResponse>(
						new OTPResponse(false, "Sorry, there was some error signing up. Please try again."),
						HttpStatus.OK);
			}
		} catch (ServiceLayerException ex) {
			return new ResponseEntity<OTPResponse>(new OTPResponse(false, "Oops! Something went wrong."),
					HttpStatus.OK);
		}
	}

	public ResponseEntity<OTPResponse> verifyOTP(final String emailId, final int otp) {
		try {
			boolean otpVerifiedSuccessfully = entryService.verifyOTP(emailId, otp);
			if (otpVerifiedSuccessfully) {
				return new ResponseEntity<OTPResponse>(new OTPResponse(true, null), HttpStatus.OK);
			} else {
				return new ResponseEntity<OTPResponse>(
						new OTPResponse(false, "Sorry, there was some error verifying OTP. Please try again."),
						HttpStatus.OK);
			}
		} catch (ServiceLayerException ex) {
			return new ResponseEntity<OTPResponse>(new OTPResponse(false, "Oops! Something went wrong."),
					HttpStatus.OK);
		}
	}

	public ResponseEntity<LawyerDTO> getLawyerDetails(final String lawyerId) {
		try {
			if (lawyerId != null && !lawyerId.isEmpty()) {
				LawyerDTO lawyerDTO = mapper.mapLawyerBOToLawyerDTO(lawyerService.getLawyerDetails(lawyerId));
				return new ResponseEntity<LawyerDTO>(lawyerDTO, HttpStatus.OK);
			}
			return new ResponseEntity<LawyerDTO>(HttpStatus.BAD_REQUEST);
		} catch (ServiceLayerException ex) {
			return new ResponseEntity<LawyerDTO>(HttpStatus.OK);
		}
	}
}
