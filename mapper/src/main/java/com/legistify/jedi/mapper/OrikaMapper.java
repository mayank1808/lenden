package com.legistify.jedi.mapper;

import org.springframework.stereotype.Component;

import com.legistify.jedi.common.bo.LawyerBO;
import com.legistify.jedi.common.dto.LawyerDTO;
import com.legistify.jedi.repository.Lawyer;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class OrikaMapper {

	private final static MapperFacade mapper;

	static {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapper = mapperFactory.getMapperFacade();
	}

	public OrikaMapper() {
	}

	public Lawyer mapLawyerBOToLawyer(final LawyerBO lawyerBO) {
		return mapper.map(lawyerBO, Lawyer.class);
	}

	public LawyerBO mapLawyerToLawyerBO(Lawyer lawyer) {
		return mapper.map(lawyer, LawyerBO.class);
	}

	public LawyerDTO mapLawyerBOToLawyerDTO(LawyerBO lawyerBO) {
		return mapper.map(lawyerBO, LawyerDTO.class);
	}
}
