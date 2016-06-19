/**
 * 
 */
package com.vedaan.lenden.dao.interfaces.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedaan.lenden.dao.generic.GenericDao;
import com.vedaan.lenden.dao.interfaces.ILoginDao;
import com.vedaan.lenden.model.request.LoginRequest;
import com.vedaan.lenden.model.response.GenericResponse;
import com.vedaan.lenden.repo.entities.UserEO;
import com.vedaan.lenden.repo.repository.UserRepository;

/**
 * @author mayank
 *
 */
@Service("loginDao")
public class LoginDao extends GenericDao<UserEO> implements ILoginDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDao.class);

	@Autowired
	UserRepository userRepo;

	@Override
	public GenericResponse checkUser(LoginRequest loginRequest) throws Exception {
		LOGGER.info("Entering registerUser at {}", System.currentTimeMillis());
		UserEO userEO = userRepo.checkUser(loginRequest.getEmailId(), loginRequest.getPassword());
		GenericResponse response = null;
		if (userEO != null) {
			response = new GenericResponse();
			response.setCode(200);
			response.setMessage("Login Successfully");
		}
		LOGGER.info("Exiting registerUser at {}", System.currentTimeMillis());
		return response;
	}

}
