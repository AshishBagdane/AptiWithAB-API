package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.models.Question;

public interface QuestionService {

	List<Question>	getAllQuestions();
	Question		getQuestionFor(long qnumber);
	Question		create(Question question);
	Question		update(long qnumber, Question question);
	Question		delete(long qnumber);
	boolean			delete();
}
