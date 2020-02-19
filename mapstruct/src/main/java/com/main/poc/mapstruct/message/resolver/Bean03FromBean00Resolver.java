package com.main.poc.mapstruct.message.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
@Named("bean03FromBean00Resolver")
public class Bean03FromBean00Resolver {
	@Value("#{${subject.teacher}}")
	Map<String,String> teacherMap;
	
	@Named("teacherMapping")
	public List<String> teacherMapping(List<String> subject) {
		List<String> listTeacher=new ArrayList<String>();
		for(String ele:subject) {
			listTeacher.add(teacherMap.get(ele));
		}
		return listTeacher;
	}
	
	@Named("examRegResolver")
	public String examRegResolver() {
		return "SomeTest";
	}

	public String setExamReg() {
		int num=(int)(Math.random()*1000);
		return num+"Y2020";
	}
	
}
