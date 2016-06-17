package com.legistify.jedi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legistify.jedi.common.bo.LawyerBO;
import com.legistify.jedi.mapper.OrikaMapper;
import com.legistify.jedi.repository.dao.LawyerDao;
import com.legistify.jedi.repository.exceptions.JediRepositoryException;
import com.legistify.jedi.service.EntryService;
import com.legistify.jedi.service.exception.ServiceLayerException;

@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	private OrikaMapper mapper;

	@Autowired
	private LawyerDao lawyerDao;

	public boolean lawyerExists(String emailId) throws ServiceLayerException {

		try {
			LawyerBO lawyerBO = mapper.mapLawyerToLawyerBO(lawyerDao.searchLawyer(emailId));
			if (lawyerBO != null && lawyerBO.getEmailId() != null && !lawyerBO.getEmailId().isEmpty()) {
				return true;
			}
			return false;
		} catch (JediRepositoryException ex) {
			throw new ServiceLayerException("Error fetching info from repository.");
		}
	}

	public boolean signupLawyer(String emailId, String password, long phoneNumber) throws ServiceLayerException {
		try {
			LawyerBO lawyerBO = new LawyerBO();
			lawyerBO.setEmailId(emailId);
			lawyerBO.setPhoneNumber(phoneNumber);
			lawyerBO.setPassword(password);
			lawyerDao.insertLawyer(mapper.mapLawyerBOToLawyer(lawyerBO));
			return true;
		} catch (JediRepositoryException ex) {
			throw new ServiceLayerException("Error fetching info from repository.");
		}
	}

	public String signinLawyer(String emailId, String password) throws ServiceLayerException {
		try {
			boolean isCredentialsValid = lawyerDao.validateLawyer(emailId, password);
			if (isCredentialsValid) {
				return emailId;
			}
			return null;
		} catch (JediRepositoryException ex) {
			throw new ServiceLayerException("Error fetching info from repository.");
		}
	}

	public boolean resendOTP(String emailId) throws ServiceLayerException {
		// TODO Auto-generated method stub
		// call external service manager from here
		return true;
	}

	public boolean verifyOTP(String emailId, int otp) throws ServiceLayerException {
		try {
			if (emailId != null && !emailId.isEmpty() && otp > 0) {
				return lawyerDao.verifyOTP(emailId, otp);
			}
			return false;
		} catch (JediRepositoryException ex) {
			throw new ServiceLayerException("Error fetching info from repository.");
		}
	}

}
