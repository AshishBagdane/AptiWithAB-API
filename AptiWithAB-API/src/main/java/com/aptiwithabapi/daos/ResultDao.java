package com.aptiwithabapi.daos;

import java.util.List;

import com.aptiwithabapi.models.Result;

public interface ResultDao {

	List<Result>	getAllResults();
	List<Result>	getAllResultsForTest(int testId);
	List<Result>	getAllResultsForStudent(int prn);
	Result			create(Result result);
	boolean			deleteAllResults();
	boolean			deleteAllResultsForTest(int testId);
	boolean			deleteAllResultsForStudent(int prn);
}