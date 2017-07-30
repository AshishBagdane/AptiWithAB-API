package com.aptiwithabapi.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Schedule {

	private int id;
	private int testId;
	private Date date;
	private boolean isConducted;
	
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public boolean getIsConducted() {
		return isConducted;
	}
	
	public void setConducted(boolean isConducted) {
		this.isConducted = isConducted;
	}
}
