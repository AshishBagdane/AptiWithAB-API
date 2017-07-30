package com.aptiwithabapi.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Option implements Comparable<Option> {

	private int questionNo;
	private byte optionNo;
	private String option;
	
	public int getQuestionNo() {
		return questionNo;
	}
	
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	
	public byte getOptionNo() {
		return optionNo;
	}
	
	public void setOptionNo(byte optionNo) {
		this.optionNo = optionNo;
	}
	
	public String getOption() {
		return option;
	}
	
	public void setOption(String option) {
		this.option = option;
	}

	@Override
	public int compareTo(Option that) {
		return this.getOptionNo() - that.getOptionNo();
	}
	
	@Override
	public String toString() {
		return this.getQuestionNo() + " " + this.getOption() + " " + this.getOptionNo();
	}
}
