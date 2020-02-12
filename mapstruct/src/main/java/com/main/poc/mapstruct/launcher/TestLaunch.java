package com.main.poc.mapstruct.launcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.main.poc.mapstruct.ext.BeanCreater;
import com.main.poc.mapstruct.message.bean.RandomBean0;
import com.main.poc.mapstruct.message.mapper.Bean01FromBean00Mapping;

//@SpringBootApplication
public class TestLaunch implements ApplicationRunner {

	@Autowired
	Bean01FromBean00Mapping mapper;

	public static void main(String[] args) {
		System.out.println("***** Map Struct POC ******");

		SpringApplication.run(TestLaunch.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		RandomBean0 bean0 = BeanCreater.createBean0();
		System.out.println(mapper.getMappedBean(bean0));
	}

}
