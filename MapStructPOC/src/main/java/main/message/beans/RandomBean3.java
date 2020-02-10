package main.message.beans;

import java.util.List;

public class RandomBean3 {
	List<String> subject;
	//depends on subject from property file
	List<String> teacher;
	//depends on name initials and roll_no
	String exam_reg;
}
