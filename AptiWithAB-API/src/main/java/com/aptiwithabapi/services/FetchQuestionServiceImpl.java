package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.FetchQuestionDao;
import com.aptiwithabapi.daos.FetchQuestionDaoImpl;
import com.aptiwithabapi.models.FetchQuestion;
import com.aptiwithabapi.models.Question;

public class FetchQuestionServiceImpl implements FetchQuestionService {

	private FetchQuestionDao dao;
	
	public FetchQuestionServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new FetchQuestionDaoImpl();
	}
	
	@Override
	public List<Question> getAllQuestionsFor(int testId) {
		// TODO Auto-generated method stub
		List<Question> questions = dao.getAllQuestionsFor(testId);
		if (questions == null) {
			
		}
		return questions;
	}

	@Override
	public Question getQuestionFor(int testId, int qnumber) {
		// TODO Auto-generated method stub
		Question question = dao.getQuestionFor(testId, qnumber);
		if (question == null) {
			
		}
		return null;
	}

	@Override
	public FetchQuestion create(FetchQuestion fetchQuestion) {
		// TODO Auto-generated method stub
		fetchQuestion = dao.create(fetchQuestion);
		if (fetchQuestion == null) {
			
		}
		return fetchQuestion;
	}

	@Override
	public FetchQuestion update(int testId, int qnumber, FetchQuestion fetchQuestion) {
		// TODO Auto-generated method stub
		fetchQuestion = dao.update(testId, qnumber, fetchQuestion);
		if (fetchQuestion == null) {
			
		}
		return fetchQuestion;
	}

	@Override
	public boolean deleteAllQuestionsFrom(int testId) {
		// TODO Auto-generated method stub
		boolean status = dao.deleteAllQuestionsFrom(testId);
		if (!status) {
			
		}
		return status;
	}

	@Override
	public FetchQuestion deleteQuestionFrom(int testId, int qnumber) {
		// TODO Auto-generated method stub
		FetchQuestion fetchQuestion = dao.deleteQuestionFrom(testId, qnumber);
		if (fetchQuestion == null) {
			
		}
		return fetchQuestion;
	}
	
}
