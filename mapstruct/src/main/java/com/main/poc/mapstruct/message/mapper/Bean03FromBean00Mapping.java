package com.main.poc.mapstruct.message.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.poc.mapstruct.message.bean.RandomBean0;
import com.main.poc.mapstruct.message.bean.RandomBean3;
import com.main.poc.mapstruct.message.resolver.Bean03FromBean00Resolver;

/**
 * @author soumodeepd
 *
 */
@Component
@Mapper(componentModel = "spring",uses = Bean03FromBean00Resolver.class)
public abstract class Bean03FromBean00Mapping implements BaseMapping<RandomBean3,RandomBean0>{

	@Autowired
	private Bean03FromBean00Resolver resolver;
	
	@Mapping(target = "subject", source = "subjectCode")
	@Mapping(target = "teacher", source = "subjectCode", qualifiedByName = "teacherMapping")
	protected abstract RandomBean3 bean3FromBean0(RandomBean0 bean);

	@Override
	public RandomBean3 getMappedBean(RandomBean0 sourceBean) {
		return bean3FromBean0(sourceBean);
	}

	@AfterMapping
	public void afterMappingBean03(RandomBean0 bean0,@MappingTarget RandomBean3 bean3) {
		bean3.setExamReg(resolver.setExamReg());
	}


	@AfterMapping
	public void afterMappingBean031(RandomBean0 bean0,@MappingTarget RandomBean3 bean3) {
		bean3.setExamReg(resolver.setExamReg());
	}

}
