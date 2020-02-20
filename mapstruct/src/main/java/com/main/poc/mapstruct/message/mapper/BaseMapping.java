package com.main.poc.mapstruct.message.mapper;

import com.main.poc.mapstruct.message.bean.MessageBean;

import CustomException.UnImplementedMethodException;

/**
 * @author soumodeepd
 *
 * @param <T>
 * @param <V>
 */
public interface BaseMapping<T  extends MessageBean, V  extends MessageBean> {
	default public T getMappedBean(V sourceBean) {
		throw new UnImplementedMethodException("BaseMapping.getMappedBean() Function not Defined ");
	}
}