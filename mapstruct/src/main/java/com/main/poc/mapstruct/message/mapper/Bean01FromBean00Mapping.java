package com.main.poc.mapstruct.message.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.main.poc.mapstruct.annotations.BeanMapping;
import com.main.poc.mapstruct.message.bean.RandomBean0;
import com.main.poc.mapstruct.message.bean.RandomBean1;

@BeanMapping(mappingFunction = "bean1FromBean0")
@Component
@Mapper(componentModel = "spring")
public abstract class Bean01FromBean00Mapping implements BaseMapping<RandomBean1,RandomBean0> {
	
	public abstract RandomBean1 bean1FromBean0(RandomBean0 bean);
	
}