package main.message.beans;

import java.util.List;
import java.util.Map;

public class RandomBean2 {
	int roll;
	List<String> subjectList;
	Map resultList;
	Person studentDetails;

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nRoll No .:" + roll).append(String.format("\nName:%s\tAddress:%s\tAge:%s", studentDetails.name,
				studentDetails.address, studentDetails.age)).append("Subject List : " + subjectList)
				.append("Result : " + resultList);
		return str.toString();
	}
}
