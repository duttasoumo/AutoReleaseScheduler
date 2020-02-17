package com.main.poc.mapstruct.message.bean;

import java.util.List;

public class RandomBean3 implements MessageBean {
	private List<String> subject;
	// depends on subject from property file
	private List<String> teacher;
	// depends on name initials and rollNo
	private String examReg;

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nTeacher List : " + teacher).append("\nSubject List : " + subject)
				.append("\nExam Registration : " + examReg);
		return str.toString();
	}

	/**
	 * @return the subject
	 */
	public List<String> getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(List<String> subject) {
		this.subject = subject;
	}

	/**
	 * @return the teacher
	 */
	public List<String> getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(List<String> teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the examReg
	 */
	public String getExamReg() {
		return examReg;
	}

	/**
	 * @param examReg the examReg to set
	 */
	public void setExamReg(String examReg) {
		this.examReg = examReg;
	}
}
