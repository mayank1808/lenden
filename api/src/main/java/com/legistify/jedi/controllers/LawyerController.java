package com.legistify.jedi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.legistify.jedi.common.dto.LawyerDTO;
import com.legistify.jedi.handler.RequestHandler;

@RestController
public class LawyerController {

	@Autowired
	RequestHandler requestHandler;

	@RequestMapping(value = "/lawyer", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<LawyerDTO> lawyerDetails(@Param(value = "lawyerId") String lawyerId) {
		if (lawyerId != null && !lawyerId.isEmpty()) {
			return requestHandler.getLawyerDetails(lawyerId);
		}
		return new ResponseEntity<LawyerDTO>(new LawyerDTO(), HttpStatus.BAD_REQUEST);
	}
}
