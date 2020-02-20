package com.main.poc.mapstruct.message.bean;

import java.util.List;
import java.util.Map;

public class RandomBean2 implements MessageBean{
	public int roll;
	public List<String> subjectList;
	public Map resultList;
	public Person studentDetails;

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nRoll No .:" + roll).append(String.format("\nName:%s\tAddress:%s\tAge:%s", studentDetails.name,
				studentDetails.address, studentDetails.age)).append(" Subject List : " + subjectList)
				.append(" Result List: " + resultList);
		return str.toString();
	}
}
