package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.models.FetchQuestion;
import com.aptiwithabapi.models.Question;

public interface FetchQuestionService {

	List<Question>	getAllQuestionsFor(int testId);
	Question		getQuestionFor(int testId, int qnumber);
	FetchQuestion	create(FetchQuestion fetchQuestion);
	FetchQuestion	update(int testId, int qnumber, FetchQuestion fetchQuestion);
	boolean			deleteAllQuestionsFrom(int testId);
	FetchQuestion	deleteQuestionFrom(int testId, int qnumber);
}
