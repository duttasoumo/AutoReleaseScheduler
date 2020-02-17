package com.main.poc.mapstruct.message.bean;

import java.util.List;
import java.util.Map;

public class RandomBean0 implements MessageBean{
	private int rollNo;
	private List<String> subjectCode;
	private Map result;
	private Person studentDetails;

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nRoll No .:" + rollNo).append(String.format("\nName:%s\tAddress:%s\tAge:%s", studentDetails.name,
				studentDetails.address, studentDetails.age)).append("Subject List : " + subjectCode)
				.append("Result : " + result);
		return str.toString();
	}

	/**
	 * @return the rollNo
	 */
	public int getRollNo() {
		return rollNo;
	}

	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * @return the subjectCode
	 */
	public List<String> getSubjectCode() {
		return subjectCode;
	}

	/**
	 * @param subjectCode the subjectCode to set
	 */
	public void setSubjectCode(List<String> subjectCode) {
		this.subjectCode = subjectCode;
	}

	/**
	 * @return the result
	 */
	public Map getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Map result) {
		this.result = result;
	}

	/**
	 * @return the studentDetails
	 */
	public Person getStudentDetails() {
		return studentDetails;
	}

	/**
	 * @param studentDetails the studentDetails to set
	 */
	public void setStudentDetails(Person studentDetails) {
		this.studentDetails = studentDetails;
	}

}
