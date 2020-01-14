package com.nri.AutoReleaseScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nri.AutoReleaseScheduler.AutoReleaseSchedulerService.ServiceScheduler;

@SpringBootApplication
public class AutoReleaseSchedulerApplication implements ApplicationRunner{

	@Autowired
	ServiceScheduler service;
	
	public static void main(String[] args) {
		SpringApplication.run(AutoReleaseSchedulerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		service.run();
	}

}
