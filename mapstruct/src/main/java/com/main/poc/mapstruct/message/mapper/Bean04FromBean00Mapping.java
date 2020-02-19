package com.main.poc.mapstruct.message.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.main.poc.mapstruct.message.bean.RandomBean0;
import com.main.poc.mapstruct.message.bean.RandomBean4;
import com.main.poc.mapstruct.message.resolver.Bean04FromBean00Resolver;

@Component
@Mapper(componentModel = "spring",uses = Bean04FromBean00Resolver.class)
public abstract class Bean04FromBean00Mapping implements BaseMapping<RandomBean4,RandomBean0>{

	@Mapping(source = "studentDetails.name",target = "firstName", qualifiedByName = "firstName")
	@Mapping(source = "studentDetails.name",target = "lastName", qualifiedByName = "lastName")
	@Mapping(source = "bean",target = "studentId", qualifiedByName = "studentId" )
	public abstract RandomBean4 bean4Bean0Mapping(RandomBean0 bean);
	
	@Override
	public RandomBean4 getMappedBean(RandomBean0 sourceBean) {
		return bean4Bean0Mapping(sourceBean);
	}
}
