package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.FetchQuestionDao;
import com.aptiwithabapi.daos.FetchQuestionDaoImpl;
import com.aptiwithabapi.exceptions.DataNotFoundException;
import com.aptiwithabapi.exceptions.DataUpdateFailedException;
import com.aptiwithabapi.models.FetchQuestion;
import com.aptiwithabapi.models.Question;

public class FetchQuestionServiceImpl implements FetchQuestionService {

	private FetchQuestionDao dao;
	
	public FetchQuestionServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new FetchQuestionDaoImpl();
	}
	
	@Override
	public List<Question> getAllQuestionsFor(long testId) {
		// TODO Auto-generated method stub
		List<Question> questions = dao.getAllQuestionsFor(testId);
		if (questions == null) {
			throw new DataNotFoundException("There are no record(s) associated with this test.");
		}
		return questions;
	}

	@Override
	public Question getQuestionFor(long testId, long qnumber) {
		// TODO Auto-generated method stub
		Question question = dao.getQuestionFor(testId, qnumber);
		if (question == null) {
			throw new DataNotFoundException("There is no record associated with this question from Test " + testId);
		}
		return null;
	}

	@Override
	public FetchQuestion create(FetchQuestion fetchQuestion) {
		// TODO Auto-generated method stub
		fetchQuestion = dao.create(fetchQuestion);
		if (fetchQuestion == null) {
			throw new DataUpdateFailedException("Resource creation failed.");
		}
		return fetchQuestion;
	}

	@Override
	public FetchQuestion update(long testId, long qnumber, FetchQuestion fetchQuestion) {
		// TODO Auto-generated method stub
		fetchQuestion = dao.update(testId, qnumber, fetchQuestion);
		if (fetchQuestion == null) {
			throw new DataNotFoundException("Resource does not exist.");
		}
		return fetchQuestion;
	}

	@Override
	public boolean deleteAllQuestionsFrom(long testId) {
		// TODO Auto-generated method stub
		boolean status = dao.deleteAllQuestionsFrom(testId);
		if (!status) {
			throw new DataNotFoundException("There are no record(s) associated with this test to delete.");
		}
		return status;
	}

	@Override
	public FetchQuestion deleteQuestionFrom(long testId, long qnumber) {
		// TODO Auto-generated method stub
		FetchQuestion fetchQuestion = dao.deleteQuestionFrom(testId, qnumber);
		if (fetchQuestion == null) {
			throw new DataNotFoundException("There are no record(s) associated with this question from test " + testId + " to delete.");
		}
		return fetchQuestion;
	}
	
}
