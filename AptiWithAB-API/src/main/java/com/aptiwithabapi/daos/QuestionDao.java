package com.aptiwithabapi.daos;

import java.util.List;

import com.aptiwithabapi.models.Question;

public interface QuestionDao {

	List<Question>	getAllQuestions();
	Question		getQuestionFor(int qnumber);
	Question		create(Question question);
	Question		update(int qnumber, Question question);
	Question		delete(int qnumber);
	boolean			delete();
}
