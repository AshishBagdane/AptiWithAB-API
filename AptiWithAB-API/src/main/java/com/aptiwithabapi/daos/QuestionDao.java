package com.aptiwithabapi.daos;

import java.util.List;

import com.aptiwithabapi.models.Question;

public interface QuestionDao {

	List<Question>	getAllQuestions();
	Question		getQuestionFor(long qnumber);
	Question		create(Question question);
	Question		update(long qnumber, Question question);
	Question		delete(long qnumber);
	boolean			delete();
}
