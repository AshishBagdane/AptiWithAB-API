package com.aptiwithabapi.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student implements Comparable<Student> {

	private int PRN;
	private String name;
	private String branch;
	private String email;
	private long contactNo;
	private String password;
	
	public int getPRN() {
		return PRN;
	}
	
	public void setPRN(int PRN) {
		this.PRN = PRN;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBranch() {
		return branch;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int compareTo(Student that) {
		return this.getPRN() - that.getPRN();
	}
}
