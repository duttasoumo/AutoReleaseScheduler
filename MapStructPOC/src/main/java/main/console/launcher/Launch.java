package main.console.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import main.exc.bean.BeanCreater;
import main.exc.bean.MapperContext;
import main.message.beans.MessageBean;
import main.message.beans.RandomBean0;
import main.message.mapper.BaseMapping;

@SpringBootApplication
public class Launch implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger(Launch.class);

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String args[]) {
		logger.info("***** Map Struct POC ******");

		SpringApplication.run(Launch.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		MessageBean bean0 = BeanCreater.createBean0();
		BaseMapping mapper = MapperContext.getMapperInstance("Bean1", "Bean0");
		System.out.println(mapper.getMappedBean((RandomBean0) bean0));
	}

}
