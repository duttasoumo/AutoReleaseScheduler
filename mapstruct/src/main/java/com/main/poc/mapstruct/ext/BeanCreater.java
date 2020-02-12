package com.main.poc.mapstruct.ext;

import java.util.ArrayList;
import java.util.HashMap;

import com.main.poc.mapstruct.message.bean.Person;
import com.main.poc.mapstruct.message.bean.RandomBean0;

public class BeanCreater {
	public static RandomBean0 createBean0() {
		RandomBean0 bean0=new RandomBean0();
		bean0.roll_no=123654;
		bean0.subjectCode=new ArrayList<String>();
		bean0.subjectCode.add("Maths");
		bean0.subjectCode.add("Sciecnce");
		bean0.subjectCode.add("SST");
		bean0.subjectCode.add("Language");
		bean0.result=new HashMap<String, Float>();
		bean0.result.put("Semester 1", 78.36);
		bean0.result.put("Semester 2", 88.36);
		bean0.result.put("Semester 3", 75.36);
		bean0.result.put("Semester 4", 85.36);
		bean0.studentDetails=new Person();
		bean0.studentDetails.name="Clerk Kent";
		bean0.studentDetails.address="KANSAS";
		bean0.studentDetails.age="32";
		bean0.studentDetails.dob="29/04/1996";
		return bean0;
	}
}
