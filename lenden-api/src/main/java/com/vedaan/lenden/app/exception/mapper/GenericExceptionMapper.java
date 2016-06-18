package com.vedaan.lenden.app.exception.mapper;

import java.security.InvalidParameterException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;

import com.vedaan.lenden.catalog.constants.Constants;
import com.vedaan.lenden.dao.exception.DatabaseAccessException;
import com.vedaan.lenden.model.response.GenericResponse;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericExceptionMapper.class);
	private static final String FOR_KEY = "for key";

	@Override
	public Response toResponse(Exception ex) {

		LOGGER.error(" Error while processing the request. msg {}", ex.getMessage());

		GenericResponse genericResponse = new GenericResponse();

		if (ex instanceof HttpMessageNotReadableException) {
			genericResponse.setCode(Constants.MESSAGE_NOT_READABLE_EXCEPTION);
			genericResponse.setMessage("Required request body content is missing");

			return Response.status(Response.Status.BAD_REQUEST).entity(genericResponse).build();

		} else if (ex instanceof org.springframework.beans.TypeMismatchException) {
			genericResponse.setCode(Constants.TYPE_MISMATCH_EXCEPTION);
			genericResponse.setMessage("Type mismatch in case of request paramters");

			return Response.status(Response.Status.BAD_REQUEST).entity(genericResponse).build();

		} else if (ex instanceof InvalidParameterException) {
			genericResponse.setCode(Constants.INVALID_PARAMETER_EXCEPTION);
			genericResponse.setMessage(ex.getMessage());

			return Response.status(Response.Status.BAD_REQUEST).entity(genericResponse).build();

		} else if (ex instanceof DataIntegrityViolationException) {
			genericResponse.setCode(Constants.SQL_UNIQUE_EXCEPTION);
			String errorCause = "Invalid entry. ";
			if (ex.getCause() != null)
				errorCause = errorCause
						.concat(((ex.getCause().getCause() != null) ? ex.getCause().getCause().getMessage() : ""));
			if (errorCause.toLowerCase().contains(FOR_KEY))
				errorCause = errorCause.substring(0, errorCause.toLowerCase().indexOf(FOR_KEY));

			genericResponse.setMessage(errorCause);
			return Response.status(Response.Status.BAD_REQUEST).entity(genericResponse).build();

		}
		if (ex instanceof ConstraintViolationException) {
			String errorCause = "Invalid entry. ";

			if (ex.getCause() != null)
				errorCause = errorCause.concat((ex.getCause().getMessage()));

			genericResponse.setCode(Constants.SQL_UNIQUE_EXCEPTION);
			if (errorCause.toLowerCase().contains(FOR_KEY)) {
				errorCause = errorCause.substring(0, errorCause.toLowerCase().indexOf(FOR_KEY));
			}

			genericResponse.setMessage(errorCause);
			return Response.status(Response.Status.BAD_REQUEST).entity(genericResponse).build();
		}
		if (ex instanceof DatabaseAccessException) {
			genericResponse.setCode(Constants.SQL_UNIQUE_EXCEPTION);
			String errorCause = "";
			if (ex.getMessage() != null)
				errorCause = errorCause.concat(((ex.getMessage() != null) ? ex.getMessage() : ""));
			if (errorCause.toLowerCase().contains(FOR_KEY))
				errorCause = errorCause.substring(0, errorCause.toLowerCase().indexOf(FOR_KEY));

			genericResponse.setMessage(errorCause);
			return Response.status(Response.Status.BAD_REQUEST).entity(genericResponse).build();

		} else if (ex instanceof InvalidParameterException) {
			genericResponse.setCode(Response.Status.BAD_REQUEST.getStatusCode());
			genericResponse.setMessage(ex.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(genericResponse).build();

		} else if (ex instanceof java.security.InvalidParameterException) {
			genericResponse.setCode(Response.Status.BAD_REQUEST.getStatusCode());
			genericResponse.setMessage(ex.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(genericResponse).build();

		} else if (ex instanceof IllegalArgumentException) {
			genericResponse.setCode(Response.Status.BAD_REQUEST.getStatusCode());
			genericResponse.setMessage(ex.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(genericResponse).build();
		} else {
			genericResponse.setCode(Constants.GENERAL_EXCEPTION);
			genericResponse.setMessage("Something went wrong pls try again later");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(genericResponse).build();

		}
	}

}
