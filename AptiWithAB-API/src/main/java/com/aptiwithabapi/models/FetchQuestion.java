package com.aptiwithabapi.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FetchQuestion {

	private int id;
	private long testId;
	private long questionNo;
	private byte marks;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTestId() {
		return testId;
	}
	
	public void setTestId(long testId) {
		this.testId = testId;
	}
	
	public long getQuestionNo() {
		return questionNo;
	}
	
	public void setQuestionNo(long questionNo) {
		this.questionNo = questionNo;
	}
	
	public byte getMarks() {
		return marks;
	}
	
	public void setMarks(byte marks) {
		this.marks = marks;
	}
}
