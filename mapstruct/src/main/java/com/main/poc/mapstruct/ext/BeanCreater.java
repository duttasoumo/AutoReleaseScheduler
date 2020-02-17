package com.main.poc.mapstruct.ext;

import java.util.ArrayList;
import java.util.HashMap;

import com.main.poc.mapstruct.message.bean.Person;
import com.main.poc.mapstruct.message.bean.RandomBean0;

public class BeanCreater {
	public static RandomBean0 createBean0() {
		RandomBean0 bean0=new RandomBean0();
		bean0.setRollNo(123654);
		bean0.setSubjectCode(new ArrayList<String>());
		bean0.getSubjectCode().add("Maths");
		bean0.getSubjectCode().add("Sciecnce");
		bean0.getSubjectCode().add("SST");
		bean0.getSubjectCode().add("Language");
		bean0.setResult(new HashMap<String, Float>());
		bean0.getResult().put("Semester 1", 78.36);
		bean0.getResult().put("Semester 2", 88.36);
		bean0.getResult().put("Semester 3", 75.36);
		bean0.getResult().put("Semester 4", 85.36);
		bean0.setStudentDetails(new Person());
		bean0.getStudentDetails().name="Clerk Kent";
		bean0.getStudentDetails().address="KANSAS";
		bean0.getStudentDetails().age="32";
		bean0.getStudentDetails().dob="29/04/1996";
		return bean0;
	}
}
