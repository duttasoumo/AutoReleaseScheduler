package com.main.poc.mapstruct.message.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.main.poc.mapstruct.message.bean.RandomBean0;
import com.main.poc.mapstruct.message.bean.RandomBean2;

@Component
@Mapper(componentModel = "spring")
public abstract class Bean02FromBean00Mapping implements BaseMapping<RandomBean2,RandomBean0>{

	 @Mapping(target = "roll", source = "rollNo")
	 @Mapping(target = "subjectList", source = "subjectCode")
	 @Mapping(target = "resultList", source = "result")
	 protected abstract RandomBean2 bean2FromBean0(RandomBean0 bean);
	 
	 @Override
	 public RandomBean2 getMappedBean(RandomBean0 sourceBean ) {
		 return bean2FromBean0(sourceBean);
	 }
}