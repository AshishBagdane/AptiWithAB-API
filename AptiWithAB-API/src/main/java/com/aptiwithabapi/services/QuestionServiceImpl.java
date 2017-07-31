package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.QuestionDao;
import com.aptiwithabapi.daos.QuestionDaoImpl;
import com.aptiwithabapi.exceptions.DataNotFoundException;
import com.aptiwithabapi.models.Question;

public class QuestionServiceImpl implements QuestionService {

	private QuestionDao dao;
	
	public QuestionServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new QuestionDaoImpl();
	}
	
	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		List<Question> questions = dao.getAllQuestions();
		if (questions == null) {
			throw new DataNotFoundException("There are no record(s).");
		}
		return questions;
	}

	@Override
	public Question getQuestionFor(long qnumber) {
		// TODO Auto-generated method stub
		Question question = dao.getQuestionFor(qnumber);
		if (question == null) {
			throw new DataNotFoundException("There is no record associated with Question " + qnumber);
		}
		return question;
	}

	@Override
	public Question create(Question question) {
		// TODO Auto-generated method stub
		question = dao.create(question);
		if (question == null) {
			
		}
		return question;
	}

	@Override
	public Question update(long qnumber, Question question) {
		// TODO Auto-generated method stub
		question = dao.update(qnumber, question);
		if (question == null) {
			
		}
		return question;
	}

	@Override
	public Question delete(long qnumber) {
		// TODO Auto-generated method stub
		Question question = delete(qnumber);
		if (question == null) {
			throw new DataNotFoundException("There is no record associated with Question " + qnumber + " to delete.");
		}
		return question;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		boolean status = dao.delete();
		if (!status) {
			throw new DataNotFoundException("There are no record(s) to delete.");
		}
		return status;
	}

}
