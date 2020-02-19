package com.main.poc.mapstruct.message.bean;

public class RandomBean4 implements MessageBean{

	public String firstName;
	public String lastName;
	//Roll number + name initials
	public String studentId; 
	
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nFirst Name :" + firstName).append("\nLast Name: " + lastName).append("\nStudentId: " + studentId);
		return str.toString();
	}
}
