package com.main.poc.mapstruct.message.mapper;

import com.main.poc.mapstruct.message.bean.MessageBean;

public interface BaseMapping<T, V> {
	MessageBean targetBean=null;
	public T getMappedBean(V sourceBean);
}
