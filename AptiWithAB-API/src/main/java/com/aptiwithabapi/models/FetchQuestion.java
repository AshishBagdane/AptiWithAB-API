package com.aptiwithabapi.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FetchQuestion {

	private int id;
	private int testId;
	private int questionNo;
	private byte marks;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTestId() {
		return testId;
	}
	
	public void setTestId(int testId) {
		this.testId = testId;
	}
	
	public int getQuestionNo() {
		return questionNo;
	}
	
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	
	public byte getMarks() {
		return marks;
	}
	
	public void setMarks(byte marks) {
		this.marks = marks;
	}
}
