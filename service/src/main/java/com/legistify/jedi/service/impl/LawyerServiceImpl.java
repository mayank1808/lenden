package com.legistify.jedi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legistify.jedi.common.bo.LawyerBO;
import com.legistify.jedi.mapper.OrikaMapper;
import com.legistify.jedi.repository.dao.LawyerDao;
import com.legistify.jedi.repository.exceptions.JediRepositoryException;
import com.legistify.jedi.service.LawyerService;
import com.legistify.jedi.service.exception.ServiceLayerException;

@Service
public class LawyerServiceImpl implements LawyerService {

	@Autowired
	private OrikaMapper mapper;

	@Autowired
	private LawyerDao lawyerDao;

	public LawyerBO getLawyerDetails(String emailId) throws ServiceLayerException {
		try {
			return mapper.mapLawyerToLawyerBO(lawyerDao.searchLawyer(emailId));
		} catch (JediRepositoryException e) {
			throw new ServiceLayerException("Error fetching info from repository.");
		}
	}

}
