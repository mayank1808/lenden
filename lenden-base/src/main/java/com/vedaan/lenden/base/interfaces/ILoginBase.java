/**
 * 
 */
package com.vedaan.lenden.base.interfaces;

import com.vedaan.lenden.model.bo.User;
import com.vedaan.lenden.model.response.GenericResponse;

/**
 * @author mayank
 *
 */
public interface ILoginBase {

	public GenericResponse registerUser(User registerRequest) throws Exception;
}
