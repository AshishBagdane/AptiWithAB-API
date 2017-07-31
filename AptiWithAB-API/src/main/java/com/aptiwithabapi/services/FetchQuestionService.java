package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.models.FetchQuestion;
import com.aptiwithabapi.models.Question;

public interface FetchQuestionService {

	List<Question>	getAllQuestionsFor(long testId);
	Question		getQuestionFor(long testId, long qnumber);
	FetchQuestion	create(FetchQuestion fetchQuestion);
	FetchQuestion	update(long testId, long qnumber, FetchQuestion fetchQuestion);
	boolean			deleteAllQuestionsFrom(long testId);
	FetchQuestion	deleteQuestionFrom(long testId, long qnumber);
}
