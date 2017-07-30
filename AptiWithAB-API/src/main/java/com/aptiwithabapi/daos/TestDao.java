package com.aptiwithabapi.daos;

import java.util.List;

import com.aptiwithabapi.models.Test;

public interface TestDao {

	List<Test> getAllTets();
	Test getTestBy(int id);
	Test create(Test test);
	Test update(int id, Test test);
	Test delete(int id);
	boolean deleteAllTests();
}
