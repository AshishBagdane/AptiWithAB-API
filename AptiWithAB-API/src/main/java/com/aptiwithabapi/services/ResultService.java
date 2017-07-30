package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.models.Result;

public interface ResultService {

	List<Result>	getAllResults();
	List<Result>	getAllResultsForTest(int testId);
	List<Result>	getAllResultsForStudent(int prn);
	Result			create(Result result);
	boolean			deleteAllResults();
	boolean			deleteAllResultsForTest(int testId);
	boolean			deleteAllResultsForStudent(int prn);
}
