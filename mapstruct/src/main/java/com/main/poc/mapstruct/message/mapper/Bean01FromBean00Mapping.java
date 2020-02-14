package com.main.poc.mapstruct.message.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.main.poc.mapstruct.message.bean.Person;
import com.main.poc.mapstruct.message.bean.RandomBean0;
import com.main.poc.mapstruct.message.bean.RandomBean1;

@Mapper(componentModel = "spring")
@Component("Bean01FromBean00Mapping")
public abstract class Bean01FromBean00Mapping implements BaseMapping<RandomBean1,RandomBean0> {
	protected abstract RandomBean1 bean1FromBean0(RandomBean0 bean);
	protected abstract Person PersonFromPerson(Person per);
	
	@Override
	public RandomBean1 getMappedBean(RandomBean0 sourceBean ) {
		 return bean1FromBean0(sourceBean);
	 }
}