package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.ResultDao;
import com.aptiwithabapi.daos.ResultDaoImpl;
import com.aptiwithabapi.models.Result;

public class ResultServiceImpl implements ResultService {

	private ResultDao dao;
	
	public ResultServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new ResultDaoImpl();
	}
	
	@Override
	public List<Result> getAllResults() {
		// TODO Auto-generated method stub
		List<Result> results = dao.getAllResults();
		if (results == null) {
			
		}
		return results;
	}

	@Override
	public List<Result> getAllResultsForTest(int testId) {
		// TODO Auto-generated method stub
		List<Result> results = dao.getAllResultsForTest(testId);
		if (results == null) {
			
		}
		return results;
	}

	@Override
	public List<Result> getAllResultsForStudent(int prn) {
		// TODO Auto-generated method stub
		List<Result> results = dao.getAllResultsForStudent(prn);
		if (results == null) {
			
		}
		return results;
	}

	@Override
	public Result create(Result result) {
		// TODO Auto-generated method stub
		result = dao.create(result);
		if (result == null) {
			
		}
		return result;
	}

	@Override
	public boolean deleteAllResults() {
		// TODO Auto-generated method stub
		boolean status = dao.deleteAllResults();
		if (!status) {
			
		}
		return status;
	}

	@Override
	public boolean deleteAllResultsForTest(int testId) {
		// TODO Auto-generated method stub
		boolean status = dao.deleteAllResultsForTest(testId);
		if (!status) {
			
		}
		return status;
	}

	@Override
	public boolean deleteAllResultsForStudent(int prn) {
		// TODO Auto-generated method stub
		boolean status = dao.deleteAllResultsForStudent(prn);
		if (!status) {
			
		}
		return status;
	}
	
}
