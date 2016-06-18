/**
 * 
 */
package com.vedaan.lenden.base.interfaces.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vedaan.lenden.base.converter.interfaces.IObjectConverter;
import com.vedaan.lenden.base.interfaces.ILoginBase;
import com.vedaan.lenden.dao.interfaces.ILoginDao;
import com.vedaan.lenden.model.bo.User;
import com.vedaan.lenden.model.response.GenericResponse;
import com.vedaan.lenden.repo.entities.UserEO;

/**
 * @author mayank
 *
 */
@Service("loginBase")
public class LoginBase implements ILoginBase {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginBase.class);

	@Autowired
	@Qualifier("loginDao")
	ILoginDao loginDao;
	
	@Autowired
	IObjectConverter<User, UserEO> userConverter;

	@Override
	public GenericResponse registerUser(User registerRequest) throws Exception {
		LOGGER.info("Entering registerUser at {}", System.currentTimeMillis());
		UserEO userEO=userConverter.convertBOToEO(registerRequest);
		userEO = loginDao.save(userEO);
		GenericResponse response=null;
		if(userEO!=null){
			response=new GenericResponse();
			response.setCode(200);
			response.setMessage("User Registered Successfully");
		}
		LOGGER.info("Exiting registerUser at {}", System.currentTimeMillis());
		return response;
	}

}
