package com.aptiwithabapi.daos;

import java.util.List;

import com.aptiwithabapi.models.Option;

public interface OptionsDao {

	List<Option>	getAllOptionsFor(int qnumber);
	Option			getOptionFor(int qnumber, int optnumber);
	List<Option>	create(List<Option> options);
	Option			update(int qnumber, int optnumber, Option option);
	boolean			delete(int qnumber);
	Option			delete(int qnumber, int optnumber);
}
