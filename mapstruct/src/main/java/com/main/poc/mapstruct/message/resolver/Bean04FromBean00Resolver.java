package com.main.poc.mapstruct.message.resolver;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.main.poc.mapstruct.message.bean.RandomBean0;

@Component
@Named("bean04FromBean00Resolver")
public class Bean04FromBean00Resolver {

	@Named("firstName")
	public String setFirstName(String name) {
		return name.split(" ")[0];
	}

	@Named("lastName")
	public String setLastName(String name) {
		return name.split(" ")[1];
	}

	@Named("lastName")
	public String setStudentId(RandomBean0 bean) {
		StringBuffer studentId = new StringBuffer();
		studentId.append(bean.getRollNo());
		String name = bean.getStudentDetails().name;
		studentId.append(name.split(" ")[0].charAt(0)).append(name.split(" ")[1].charAt(0));
		return studentId.toString();
	}

}
