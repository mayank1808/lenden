package com.legistify.jedi.service;

import com.legistify.jedi.service.exception.ServiceLayerException;

public interface EntryService {

	/**
	 * Returns true if lawyer with given emailId already exists.
	 * 
	 * @param emailId
	 * @return
	 * @throws ServiceLayerException
	 */
	public boolean lawyerExists(final String emailId) throws ServiceLayerException;

	/**
	 * Sign-up new Lawyer returning true if the process was successful.
	 * 
	 * @param emailId
	 * @param password
	 * @param phoneNumber
	 * @return
	 * @throws ServiceLayerException
	 */
	public boolean signupLawyer(final String emailId, final String password, final long phoneNumber)
			throws ServiceLayerException;

	/**
	 * Returns lawyer's mail if signin is successful, else null.
	 * 
	 * @param emailId
	 * @param password
	 * @return
	 * @throws ServiceLayerException
	 */
	public String signinLawyer(final String emailId, final String password) throws ServiceLayerException;

	public boolean resendOTP(final String lawyerId) throws ServiceLayerException;

	public boolean verifyOTP(final String emailId, final int otp) throws ServiceLayerException;

}
