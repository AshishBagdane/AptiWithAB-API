package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.models.Question;

public interface QuestionService {

	List<Question>	getAllQuestions();
	Question		getQuestionFor(int qnumber);
	Question		create(Question question);
	Question		update(int qnumber, Question question);
	Question		delete(int qnumber);
	boolean			delete();
}
