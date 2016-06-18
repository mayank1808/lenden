package com.vedaan.lenden.base.converter.interfaces;

public interface IObjectConverter<B, E> {

	public B convertEOToBO(E eo) throws Exception;

	public E convertBOToEO(B bo) throws Exception;

}
