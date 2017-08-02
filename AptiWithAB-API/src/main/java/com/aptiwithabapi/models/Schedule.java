package com.aptiwithabapi.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Schedule implements Comparable<Schedule> {

	private long id;
	private long testId;
	private Date date;
	private boolean isConducted;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTestId() {
		return testId;
	}
	
	public void setTestId(long testId) {
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

	@Override
	public int compareTo(Schedule that) {
		// TODO Auto-generated method stub
		return Long.compare(this.getId(), that.getId());
	}
}
