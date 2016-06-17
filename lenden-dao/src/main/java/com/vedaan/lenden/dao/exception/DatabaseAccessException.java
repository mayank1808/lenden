package com.vedaan.lenden.dao.exception;

import org.hibernate.HibernateException;

public class DatabaseAccessException extends HibernateException {

	private static final long serialVersionUID = 5978856523103192405L;

	public DatabaseAccessException(String message) {
		super(message);
	}

	public DatabaseAccessException(String message, Throwable cause) {
		super(message, cause);
	}

}
