package com.main.poc.mapstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.main.poc.mapstruct.ext.BeanCreater;
import com.main.poc.mapstruct.ext.MapperContext;
import com.main.poc.mapstruct.message.bean.RandomBean0;

@SpringBootApplication
public class MapstructApplication implements ApplicationRunner {

	@Autowired
	MapperContext mapperCtx;

	public static void main(String[] args) {
		System.out.println("***** Map Struct POC ******");

		SpringApplication.run(MapstructApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		RandomBean0 bean0 = BeanCreater.createBean0();
		System.out.println(mapperCtx.convert("bean3", "bean0", bean0));

	}

}
