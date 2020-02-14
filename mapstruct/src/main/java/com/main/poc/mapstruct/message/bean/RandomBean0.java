package com.main.poc.mapstruct.message.bean;

import java.util.List;
import java.util.Map;

public class RandomBean0 implements MessageBean{
	public int rollNo;
	public List<String> subjectCode;
	public Map result;
	public Person studentDetails;

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nRoll No .:" + rollNo).append(String.format("\nName:%s\tAddress:%s\tAge:%s", studentDetails.name,
				studentDetails.address, studentDetails.age)).append("Subject List : " + subjectCode)
				.append("Result : " + result);
		return str.toString();
	}

}
