package com.main.poc.mapstruct.message.bean;

import java.util.List;

public class RandomBean3 implements MessageBean {
	public List<String> subject;
	// depends on subject from property file
	public List<String> teacher;
	// depends on name initials and rollNo
	public String examReg;

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nTeacher List :" + teacher).append("\nSubject List : " + subject)
				.append("\nExam Registration : " + examReg);
		return str.toString();
	}
}
