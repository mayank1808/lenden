/**
 * 
 */
package com.vedaan.lenden.dao.interfaces;

import com.vedaan.lenden.dao.generic.IConfigDao;
import com.vedaan.lenden.model.request.LoginRequest;
import com.vedaan.lenden.model.response.GenericResponse;
import com.vedaan.lenden.repo.entities.UserEO;

/**
 * @author mayank
 *
 */
public interface ILoginDao extends IConfigDao<UserEO> {

	public GenericResponse checkUser(LoginRequest loginRequest) throws Exception;

}
