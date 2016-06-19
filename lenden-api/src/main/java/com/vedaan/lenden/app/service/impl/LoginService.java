/**
 * 
 */
package com.vedaan.lenden.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vedaan.lenden.app.service.ILoginService;
import com.vedaan.lenden.base.interfaces.ILoginBase;
import com.vedaan.lenden.model.bo.User;
import com.vedaan.lenden.model.request.LoginRequest;
import com.vedaan.lenden.model.response.GenericResponse;

/**
 * @author mayank
 *
 */
@Service("loginService")
public class LoginService implements ILoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	@Qualifier("loginBase")
	ILoginBase loginBase;

	@Override
	public GenericResponse registerUser(User registerRequest) throws Exception {
		LOGGER.info("Entering registerUser at {}", System.currentTimeMillis());
		GenericResponse response = loginBase.registerUser(registerRequest);
		LOGGER.info("Exiting registerUser at {}", System.currentTimeMillis());
		return response;
	}

	@Override
	public GenericResponse loginUser(LoginRequest loginRequest) throws Exception {
		LOGGER.info("Entering registerUser at {}", System.currentTimeMillis());
		GenericResponse response = loginBase.loginUser(loginRequest);
		LOGGER.info("Exiting registerUser at {}", System.currentTimeMillis());
		return response;
	}

}
