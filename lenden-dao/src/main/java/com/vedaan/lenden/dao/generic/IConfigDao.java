package com.vedaan.lenden.dao.generic;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

public interface IConfigDao<T> {

	public T save(T instance) throws DuplicateKeyException, Exception;

	public T removeById(final int id) throws Exception;

	public T update(T instance, final int id) throws Exception;

	public T getById(final int id) throws Exception;

	public List<T> getAll() throws Exception;

	public String get_In_StatementString(final List<String> limitIds);

}
