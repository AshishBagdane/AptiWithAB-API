package com.aptiwithabapi.models;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Question implements Comparable<Question> {

	private long no;
	private String type;
	private String statement;
	private String answer;
	private String imageURL;
	private int marks;
	private List<Option> options;
	
	public long getNo() {
		return no;
	}
	
	public void setNo(long no) {
		this.no = no;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getStatement() {
		return statement;
	}
	
	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@XmlTransient
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@XmlTransient
	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@Override
	public int compareTo(Question that) {
		return Long.compare(this.getNo(), that.getNo());
	}
}
