package com.main.poc.mapstruct.message.resolver;

import java.util.Arrays;
import java.util.List;

import org.mapstruct.Named;
@Named("Bean03FromBean00Resolver")
public class Bean03FromBean00Resolver {
//	@Value("${subject.teacher.Maths}")
	String test="SomeOptional";
	@Named("teacherMapping")
	public List<String> teacherMapping() {
		String []listTeacher={test,"SomeTeacher"};
		return Arrays.asList(listTeacher);
	}
	
	@Named("examRegResolver")
	public String examRegResolver() {
		return "SomeTest";
	}
	
}
