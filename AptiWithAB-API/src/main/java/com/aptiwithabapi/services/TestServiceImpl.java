package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.TestDao;
import com.aptiwithabapi.daos.TestDaoImpl;
import com.aptiwithabapi.exceptions.DataNotFoundException;
import com.aptiwithabapi.models.Test;

public class TestServiceImpl implements TestService {
	
	private TestDao dao;
	
	public TestServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new TestDaoImpl();
	}

	@Override
	public List<Test> getAllTets() {
		// TODO Auto-generated method stub
		List<Test> tests = dao.getAllTets();
		if (tests == null) {
			throw new DataNotFoundException("There are no records.");
		}
		return tests;
	}

	@Override
	public Test getTestBy(long id) {
		// TODO Auto-generated method stub
		Test test = dao.getTestBy(id);
		if (test == null) {
			throw new DataNotFoundException("Test with id " + id + " does not exists.");
		}
		return test;
	}

	@Override
	public Test create(Test test) {
		// TODO Auto-generated method stub
		test = dao.create(test);
		if (test == null) {
			
		}
		return test;
	}

	@Override
	public Test update(long id, Test test) {
		// TODO Auto-generated method stub
		test = dao.update(id, test);
		if (test == null) {
			throw new DataNotFoundException("Test with id " + id + " does not exists.");
		}
		return test;
	}

	@Override
	public Test delete(long id) {
		// TODO Auto-generated method stub
		Test test = dao.delete(id);
		if (test == null) {
			throw new DataNotFoundException("Test with id " + id + " does not exists.");
		}
		return test;
	}

	@Override
	public boolean deleteAllTests() {
		// TODO Auto-generated method stub
		boolean status = dao.deleteAllTests();
		if (!status) {
			throw new DataNotFoundException("There are no records to delete.");
		}
		return status;
	}
	
}
