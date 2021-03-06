package com.aptiwithabapi.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Test implements Comparable<Test> {

	private long id;
	private String name;
	private String createdBy;
	private int duration;
	private int noOfQuestions;
	
	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getNoOfQuestions() {
		return noOfQuestions;
	}
	
	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	@Override
	public int compareTo(Test that) {
		return Long.compare(this.getId(), that.getId());
	}
}
