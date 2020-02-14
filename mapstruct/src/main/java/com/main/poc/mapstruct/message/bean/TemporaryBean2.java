package com.main.poc.mapstruct.message.bean;

import java.io.Serializable;
import java.util.List;

public class TemporaryBean2 implements Serializable{
	private String name;
	private String[] address;
	private String college;
	private String country;
	private long roll_no;
	private String registration;
	private int cl;
	private String sec;
	private String[] subject;
	private String[] teacher;
	private List prevQualification;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String[] getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String[] address) {
		this.address = address;
	}
	/**
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * @return the registration
	 */
	public String getRegistration() {
		return registration;
	}
	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the rollNo
	 */
	public long getRoll_no() {
		return roll_no;
	}
	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRoll_no(long roll_no) {
		this.roll_no = roll_no;
	}
	/**
	 * @return the cl
	 */
	public int getCl() {
		return cl;
	}
	/**
	 * @param cl the cl to set
	 */
	public void setCl(int cl) {
		this.cl = cl;
	}
	/**
	 * @return the sec
	 */
	public String getSec() {
		return sec;
	}
	/**
	 * @param sec the sec to set
	 */
	public void setSec(String sec) {
		this.sec = sec;
	}
	/**
	 * @return the subject
	 */
	public String[] getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String[] subject) {
		this.subject = subject;
	}
	/**
	 * @return the teacher
	 */
	public String[] getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(String[] teacher) {
		this.teacher = teacher;
	}
	/**
	 * @return Prev Qualification
	 */
	public List<Qualification> getPrevQualification() {
		return prevQualification;
	}
	/**
	 * @param prevQualification
	 */
	public void setPrevQualification(List<Qualification> prevQualification) {
		this.prevQualification = prevQualification;
	}
	
}
