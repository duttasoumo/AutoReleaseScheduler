package com.main.poc.mapstruct.message.bean;

import java.io.Serializable;

public class TemporaryBean1 implements Serializable{
	private String studentName;
	private String address;
	private String class_code;
	private String[] subject_code;
	private String roll_no;
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the class_code
	 */
	public String getClass_code() {
		return class_code;
	}
	/**
	 * @param class_code the class_code to set
	 */
	public void setClass_code(String class_code) {
		this.class_code = class_code;
	}
	/**
	 * @return the subject_code
	 */
	public String[] getSubject_code() {
		return subject_code;
	}
	/**
	 * @param subject_code the subject_code to set
	 */
	public void setSubject_code(String[] subject_code) {
		this.subject_code = subject_code;
	}
	/**
	 * @return the roll_no
	 */
	public String getRoll_no() {
		return roll_no;
	}
	/**
	 * @param roll_no the roll_no to set
	 */
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
}
