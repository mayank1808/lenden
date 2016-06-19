/**
 * 
 */
package com.vedaan.lenden.app.service;

import com.vedaan.lenden.model.bo.User;
import com.vedaan.lenden.model.request.LoginRequest;
import com.vedaan.lenden.model.response.GenericResponse;

/**
 * @author mayank
 *
 */
public interface ILoginService {

	public GenericResponse registerUser(User registerRequest) throws Exception;

	public GenericResponse loginUser(LoginRequest loginRequest) throws Exception;
}
