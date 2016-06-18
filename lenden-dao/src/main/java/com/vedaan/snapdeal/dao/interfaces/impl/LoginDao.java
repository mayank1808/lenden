/**
 * 
 */
package com.vedaan.snapdeal.dao.interfaces.impl;

import org.springframework.stereotype.Service;

import com.vedaan.lenden.dao.generic.GenericDao;
import com.vedaan.lenden.dao.interfaces.ILoginDao;
import com.vedaan.lenden.repo.entities.UserEO;

/**
 * @author mayank
 *
 */
@Service
public class LoginDao extends GenericDao<UserEO> implements ILoginDao {

}
