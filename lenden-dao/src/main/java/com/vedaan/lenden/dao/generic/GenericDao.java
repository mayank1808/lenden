package com.vedaan.lenden.dao.generic;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vedaan.lenden.dao.exception.ExceptionHandler;

public class GenericDao<T> implements IConfigDao<T> {

	/** The Constant Log. */
	private static final Logger LOG = LoggerFactory.getLogger(GenericDao.class);

	@Autowired
	private JpaRepository<T, Integer> repo;

	@Override
	public T save(T instance) throws DuplicateKeyException, Exception {

		LOG.info("saving...");

		try {

			return repo.save(instance);

		} catch (DuplicateKeyException e) {
			LOG.error("while performing add operation", e);
			throw e;
		} catch (DataIntegrityViolationException e) {
			LOG.error("while performing add operation", e);
			throw ExceptionHandler.getCause(e);
		} catch (ConstraintViolationException e) {
			LOG.error("while performing add operation", e);
			throw ExceptionHandler.getCause(e);
		} catch (Exception e) {
			LOG.error("while performing add operation", e);
			throw e;
		}
	}

	@Override
	public T removeById(final int id) throws Exception {

		LOG.info("Removing by id {}  ....", id);

		try {
			T result = repo.findOne(id);

			if (result == null)
				throw new IllegalArgumentException("No row with the given identifier exists");

			repo.delete(result);

			return result;
		} catch (DataIntegrityViolationException e) {
			LOG.error("while performing remove operation", e);
			throw ExceptionHandler.getCause(e);
		} catch (ConstraintViolationException e) {
			LOG.error("while performing remove operation ", e);
			throw ExceptionHandler.getCause(e);
		} catch (Exception e) {

			LOG.error("while performing remove operation ", e);
			throw e;
		}
	}

	@Override
	public T update(T instance, int id) throws Exception {

		LOG.info("updating....");

		try {
			T temp = repo.findOne(id);
			if (temp == null)
				throw new IllegalArgumentException("No row with the given identifier exists");

			return repo.save(instance);

		} catch (DataIntegrityViolationException e) {
			LOG.error("while performing add operation", e);
			throw ExceptionHandler.getCause(e);
		} catch (ConstraintViolationException e) {
			LOG.error("while performing update operation ", e);
			throw ExceptionHandler.getCause(e);
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {

			LOG.error("while performing update operation ", e);
			throw e;
		}
	}

	@Override
	public T getById(final int id) throws Exception {

		LOG.info("get config object by id {}....", id);

		try {

			return repo.findOne(id);

		} catch (DataIntegrityViolationException e) {
			LOG.error("while performing add operation", e);
			throw ExceptionHandler.getCause(e);
		} catch (ConstraintViolationException e) {
			LOG.error("while performing remove operation", e);
			throw ExceptionHandler.getCause(e);
		} catch (Exception e) {

			LOG.error("while performing remove operation", e);
			throw e;
		}
	}

	@Override
	public List<T> getAll() throws Exception {

		LOG.info("get all.. ");

		try {
			return repo.findAll();
		} catch (DataIntegrityViolationException e) {
			LOG.error("while performing add operation", e);
			throw ExceptionHandler.getCause(e);
		} catch (ConstraintViolationException e) {
			LOG.error("while performing get all operation ", e);
			throw ExceptionHandler.getCause(e);
		} catch (Exception e) {
			LOG.error("while performing get all operation ", e);
			throw e;
		}
	}

	@Override
	public String get_In_StatementString(final List<String> input) throws IllegalArgumentException {
		if (null == input || input.isEmpty())
			return null;

		final StringBuilder output = new StringBuilder();
		output.append("(");
		int i = 0;
		for (String l : input) {
			if ("null".equals(l) || l.isEmpty())
				throw new IllegalArgumentException("input is wrongly formated");

			i++;
			output.append(l);
			if (i != input.size())
				output.append(",");
		}
		output.append(")");
		return output.toString();
	}
}
