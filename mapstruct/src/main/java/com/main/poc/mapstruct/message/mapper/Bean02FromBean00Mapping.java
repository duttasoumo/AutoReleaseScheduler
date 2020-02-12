package com.main.poc.mapstruct.message.mapper;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

import com.main.poc.mapstruct.message.bean.Person;
import com.main.poc.mapstruct.message.bean.RandomBean0;
import com.main.poc.mapstruct.message.bean.RandomBean2;

@MapperConfig(componentModel = "spring",implementationName="Bean02FromBean00MappingImpl",implementationPackage="com.main.poc.mapstruct.message.mapper.impl")
public abstract class Bean02FromBean00Mapping implements BaseMapping<RandomBean2,RandomBean0>{
	protected abstract Person personFromPerson(Person per); 
	 @Mapping(target = "roll", source = "roll_no")
	 @Mapping(target = "subjectList", source = "subjectCode")
	 @Mapping(target = "resultList", source = "result")
	 protected abstract RandomBean2 bean2FromBean0(RandomBean0 bean);
	 
	 @BeforeMapping
	 @Override
	 public RandomBean2 getMappedBean(RandomBean0 sourceBean ) {
		 return bean2FromBean0(sourceBean);
	 }
}
