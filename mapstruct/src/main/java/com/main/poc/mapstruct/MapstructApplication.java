package com.main.poc.mapstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.main.poc.mapstruct.ext.BeanCreater;
import com.main.poc.mapstruct.message.bean.RandomBean0;
import com.main.poc.mapstruct.message.mapper.BaseMapping;

@SpringBootApplication
public class MapstructApplication implements ApplicationRunner{
	@Autowired
	@Qualifier("Bean02FromBean00Mapping")
	BaseMapping mapper;
	@Autowired
	private ApplicationContext applicationContext;
	public static void main(String[] args) {
		System.out.println("***** Map Struct POC ******");

		SpringApplication.run(MapstructApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		BaseMapping mapper = applicationContext.getBean("Bean02FromBean00Mapping",BaseMapping.class);
		RandomBean0 bean0 = BeanCreater.createBean0();
		System.out.println(mapper.getMappedBean(bean0));
	}
}
