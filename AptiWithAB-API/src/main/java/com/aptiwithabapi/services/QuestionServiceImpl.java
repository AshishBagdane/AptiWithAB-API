package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.QuestionDao;
import com.aptiwithabapi.daos.QuestionDaoImpl;
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
			
		}
		return questions;
	}

	@Override
	public Question getQuestionFor(int qnumber) {
		// TODO Auto-generated method stub
		Question question = dao.getQuestionFor(qnumber);
		if (question == null) {
			
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
	public Question update(int qnumber, Question question) {
		// TODO Auto-generated method stub
		question = dao.update(qnumber, question);
		if (question == null) {
			
		}
		return question;
	}

	@Override
	public Question delete(int qnumber) {
		// TODO Auto-generated method stub
		Question question = delete(qnumber);
		if (question == null) {
			
		}
		return question;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		boolean status = dao.delete();
		if (!status) {
			
		}
		return status;
	}

}
