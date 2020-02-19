package com.main.poc.mapstruct.message.mapper;

import org.springframework.beans.factory.annotation.Autowired;

public class MappingInstance<T> {

	@Autowired
	private T mapper;

	public T getMapper() {
		return mapper;
	}

	public void setMapper(T mapper) {
		this.mapper = mapper;
	}
	
}
