package com.aptiwithabapi.daos;

import java.util.List;

import com.aptiwithabapi.models.Test;

public interface TestDao {

	List<Test> getAllTets();
	Test getTestBy(long id);
	Test create(Test test);
	Test update(long id, Test test);
	Test delete(long id);
	boolean deleteAllTests();
}
