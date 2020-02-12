package main.console.launcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;

import main.exc.bean.BeanCreater;
import main.message.beans.RandomBean0;
import main.message.mapper.Bean01FromBean00Mapping;

public class TestLaunch implements ApplicationRunner {

	@Autowired
	Bean01FromBean00Mapping mapper;
	public static void main(String[] args) {
		System.out.println("***** Map Struct POC ******");

		SpringApplication.run(Launch.class, args);


	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		RandomBean0 bean0=BeanCreater.createBean0();
		System.out.println(mapper.getMappedBean(bean0));
	}

}
