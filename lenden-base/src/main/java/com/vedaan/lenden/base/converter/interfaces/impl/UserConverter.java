/**
 * 
 */
package com.vedaan.lenden.base.converter.interfaces.impl;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.vedaan.lenden.base.converter.interfaces.IObjectConverter;
import com.vedaan.lenden.model.bo.Community;
import com.vedaan.lenden.model.bo.User;
import com.vedaan.lenden.repo.entities.CommunityEO;
import com.vedaan.lenden.repo.entities.UserEO;

/**
 * @author mayank
 *
 */
@Service("userConverter")
public class UserConverter implements IObjectConverter<User, UserEO> {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserConverter.class);

	@Autowired
	IObjectConverter<Community, CommunityEO> communityConverter;

	@Override
	public User convertEOToBO(UserEO eo) throws Exception {
		LOGGER.info("Entering convertEOToBO at {}", System.currentTimeMillis());
		User user = new User();
		user.setFirstName(eo.getFirstName());
		user.setLastName(eo.getLastName());
		user.setContact(eo.getContact());
		user.setEmailId(eo.getEmailId());
		user.setAddress(eo.getAddress());
		user.setCity(eo.getCity());
		user.setState(eo.getState());
		user.setPincode(eo.getPincode());
		List<Community> communities = new ArrayList<Community>();
		for (CommunityEO communityEO : eo.getCommunities()) {
			communities.add(communityConverter.convertEOToBO(communityEO));
		}
		user.setCommunities(communities);
		LOGGER.info("Exiting convertEOToBO at {}", System.currentTimeMillis());
		return user;
	}

	@Override
	public UserEO convertBOToEO(User bo) throws Exception {
		LOGGER.info("Entering convertBOToEO at {}", System.currentTimeMillis());
		UserEO userEO = new UserEO();
		userEO.setFirstName(bo.getFirstName());
		userEO.setLastName(bo.getLastName());
		userEO.setContact(bo.getContact());
		userEO.setEmailId(bo.getEmailId());
		userEO.setAddress(bo.getAddress());
		userEO.setCity(bo.getCity());
		userEO.setState(bo.getState());
		userEO.setPincode(bo.getPincode());
		List<CommunityEO> communitiesEO = new ArrayList<CommunityEO>();
		for (Community community : bo.getCommunities()) {
			communitiesEO.add(communityConverter.convertBOToEO(community));
		}
		userEO.setCommunities(communitiesEO);
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(bo.getPassword().getBytes());
		byte[] digest = m.digest();
		userEO.setPassword(DigestUtils.md5DigestAsHex(digest));

		LOGGER.info("Exiting convertBOToEO at {}", System.currentTimeMillis());
		return userEO;
	}

}
