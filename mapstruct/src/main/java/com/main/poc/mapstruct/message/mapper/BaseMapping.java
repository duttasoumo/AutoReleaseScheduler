package com.main.poc.mapstruct.message.mapper;

import com.main.poc.mapstruct.message.bean.MessageBean;

public interface BaseMapping<T  extends MessageBean, V  extends MessageBean> {
	public T getMappedBean(V sourceBean);
}