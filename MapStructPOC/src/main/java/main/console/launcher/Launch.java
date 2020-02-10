package main.console.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.message.mapper.BaseMapping;
@SpringBootApplication
public class Launch  implements ApplicationRunner {
	
	private static final Logger logger = LogManager.getLogger(Launch.class);
	
	public static void main(String args[]) {
		logger.info("***** Map Struct POC ******");
		
		SpringApplication.run(Launch.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		BaseMapping mapper=SpringCon
		
	}

}
