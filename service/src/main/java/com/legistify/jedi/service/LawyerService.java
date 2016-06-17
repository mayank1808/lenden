package com.legistify.jedi.service;

import com.legistify.jedi.common.bo.LawyerBO;
import com.legistify.jedi.service.exception.ServiceLayerException;

public interface LawyerService {

	public LawyerBO getLawyerDetails(final String emailId) throws ServiceLayerException;

}
