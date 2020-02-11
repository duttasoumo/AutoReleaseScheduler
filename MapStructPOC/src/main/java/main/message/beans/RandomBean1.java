package main.message.beans;

import java.util.List;
import java.util.Map;

public class RandomBean1 implements MessageBean{
	private int roll_no;
	private List<String> subjectCode;
	private Map result;
	private Person studentDetails;

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public List<String> getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(List<String> subject) {
		this.subjectCode = subject;
	}

	public Map getResult() {
		return result;
	}

	public void setResult(Map result) {
		this.result = result;
	}

	public Person getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(Person studentDetails) {
		this.studentDetails = studentDetails;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nRoll No .:" + roll_no).append(String.format("\nName:%s\tAddress:%s\tAge:%s", studentDetails.name,
				studentDetails.address, studentDetails.age)).append("Subject List : " + subjectCode)
				.append("Result : " + result);
		return str.toString();
	}
}
