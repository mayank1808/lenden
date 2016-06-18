/**
 * 
 */
package com.vedaan.lenden.base.converter.interfaces.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vedaan.lenden.base.converter.interfaces.IObjectConverter;
import com.vedaan.lenden.model.bo.Community;
import com.vedaan.lenden.repo.entities.CommunityEO;

/**
 * @author mayank
 *
 */
@Service("communityConverter")
public class CommunityConverter implements IObjectConverter<Community, CommunityEO> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommunityConverter.class);

	@Override
	public Community convertEOToBO(CommunityEO eo) throws Exception {
		LOGGER.info("Entering convertEOToBO at {}", System.currentTimeMillis());
		Community community = new Community();
		community.setCommunityName(eo.getCommunityName());
		community.setType(eo.getType());
		community.setCity(eo.getCity());
		community.setType(eo.getType());
		LOGGER.info("Exiting convertEOToBO at {}", System.currentTimeMillis());
		return community;
	}

	@Override
	public CommunityEO convertBOToEO(Community bo) throws Exception {
		LOGGER.info("Entering convertBOToEO at {}", System.currentTimeMillis());
		CommunityEO communityEO = new CommunityEO();
		communityEO.setCommunityName(bo.getCommunityName());
		communityEO.setType(bo.getType());
		communityEO.setCity(bo.getCity());
		communityEO.setType(bo.getType());
		LOGGER.info("Exiting convertBOToEO at {}", System.currentTimeMillis());
		return communityEO;
	}

}
