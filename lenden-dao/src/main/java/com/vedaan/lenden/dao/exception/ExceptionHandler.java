package com.vedaan.lenden.dao.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

public class ExceptionHandler {
	public static DatabaseAccessException getCause(DataIntegrityViolationException ex) {
		throw new DatabaseAccessException(getErrorCause(ex));
	}

	public static DatabaseAccessException getCause(ConstraintViolationException ex) {
		throw new DatabaseAccessException(getErrorCause(ex));
	}

	private static String getErrorCause(Exception ex) {
		String errorCause = "Invalid entry. ";

		if (ex.getCause() != null)
			if (ex instanceof DataIntegrityViolationException)
				errorCause = errorCause
						.concat(((ex.getCause().getCause() != null) ? ex.getCause().getCause().getMessage() : ""));
		if (ex instanceof ConstraintViolationException)
			errorCause = errorCause.concat((ex.getCause().getMessage()));

		return errorCause;
	}

}
