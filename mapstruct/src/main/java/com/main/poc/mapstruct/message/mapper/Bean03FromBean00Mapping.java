package com.main.poc.mapstruct.message.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.main.poc.mapstruct.message.bean.RandomBean0;
import com.main.poc.mapstruct.message.bean.RandomBean3;
import com.main.poc.mapstruct.message.resolver.Bean03FromBean00Resolver;

@Component
@Mapper(componentModel = "spring",uses = Bean03FromBean00Resolver.class)
public abstract class Bean03FromBean00Mapping implements BaseMapping<RandomBean3,RandomBean0>{

	@Mapping(target = "subject", source = "subjectCode")
	@Mapping(target = "teacher", qualifiedByName = {"teacherMapping"})
	@Mapping(target = "examReg", qualifiedByName = {"examRegResolver"})
	protected abstract RandomBean3 bean3FromBean0(RandomBean0 bean);
	
	@Override
	public RandomBean3 getMappedBean(RandomBean0 sourceBean) {
		return bean3FromBean0(sourceBean);
	}

}
