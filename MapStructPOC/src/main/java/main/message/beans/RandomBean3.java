package main.message.beans;

import java.util.List;

public class RandomBean3 implements MessageBean {
	List<String> subject;
	// depends on subject from property file
	List<String> teacher;
	// depends on name initials and roll_no
	String exam_reg;

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nTeacher List :" + teacher).append("\nSubject List : " + subject)
				.append("\nExam Registration : " + exam_reg);
		return str.toString();
	}
}
