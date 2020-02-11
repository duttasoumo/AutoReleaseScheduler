package main.message.beans;

public class RandomBean4 implements MessageBean{

	String firstName;
	String lastName;
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nFirst Name :" + firstName).append("\nLast Name: " + lastName);
		return str.toString();
	}
}
