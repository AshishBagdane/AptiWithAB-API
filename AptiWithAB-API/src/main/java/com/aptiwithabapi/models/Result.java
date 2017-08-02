package com.aptiwithabapi.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result implements Comparable<Result> {

	private long id;
	private int studentPRN;
	private long testId;
	private double marks;
	private String grade;
	private Date date;
	
	public Result() {
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStudentPRN() {
		return studentPRN;
	}
	
	public void setStudentPRN(int studentPRN) {
		this.studentPRN = studentPRN;
	}
	
	public long getTestId() {
		return testId;
	}
	
	public void setTestId(long testId) {
		this.testId = testId;
	}
	
	public double getMarks() {
		return marks;
	}
	
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(Result that) {
		if(this.getTestId() == that.getTestId()) {
			return this.getStudentPRN() - that.getStudentPRN();
		} else {
			return Long.compare(this.getTestId(), that.getTestId());
		}
	}
}
