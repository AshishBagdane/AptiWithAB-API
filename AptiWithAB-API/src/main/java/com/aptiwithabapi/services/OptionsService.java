package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.models.Option;

public interface OptionsService {

	List<Option>	getAllOptionsFor(long qnumber);
	Option			getOptionFor(long qnumber, int optnumber);
	List<Option>	create(List<Option> options);
	Option			update(long qnumber, int optnumber, Option option);
	boolean			delete(long qnumber);
	Option			delete(long qnumber, int optnumber);
}
