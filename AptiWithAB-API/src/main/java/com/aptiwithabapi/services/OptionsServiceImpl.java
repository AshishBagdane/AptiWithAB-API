package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.OptionsDao;
import com.aptiwithabapi.daos.OptionsDaoImpl;
import com.aptiwithabapi.exceptions.DataNotFoundException;
import com.aptiwithabapi.exceptions.DataUpdateFailedException;
import com.aptiwithabapi.models.Option;

public class OptionsServiceImpl implements OptionsService {

	private OptionsDao dao;
	
	public OptionsServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new OptionsDaoImpl();
	}
	
	@Override
	public List<Option> getAllOptionsFor(long qnumber) {
		// TODO Auto-generated method stub
		List<Option> options = dao.getAllOptionsFor(qnumber);
		if (options == null) {
			throw new DataNotFoundException("There are no record(s) associated with this question.");
		}
		return options;
	}

	@Override
	public Option getOptionFor(long qnumber, int optnumber) {
		// TODO Auto-generated method stub
		Option option = dao.getOptionFor(qnumber, optnumber);
		if (option == null) {
			throw new DataNotFoundException("There is no record for this option associated with question " + qnumber + ".");
		}
		return null;
	}

	@Override
	public List<Option> create(List<Option> options) {
		// TODO Auto-generated method stub
		options = dao.create(options);
		if (options == null) {
			throw new DataUpdateFailedException("Resource creation failed.");
		}
		return options;
	}

	@Override
	public Option update(long qnumber, int optnumber, Option option) {
		// TODO Auto-generated method stub
		option = dao.update(qnumber, optnumber, option);
		if (option == null) {
			throw new DataNotFoundException("Option does not exist.");
		}
		return option;
	}

	@Override
	public boolean delete(long qnumber) {
		// TODO Auto-generated method stub
		boolean status = dao.delete(qnumber);
		if (!status) {
			throw new DataNotFoundException("There are no record(s) associated with this question to delete.");
		}
		return status;
	}

	@Override
	public Option delete(long qnumber, int optnumber) {
		// TODO Auto-generated method stub
		Option option = dao.delete(qnumber, optnumber);
		if (option == null) {
			throw new DataNotFoundException("There is no such record associated with this question to delete.");
		}
		return option;
	}
	
}
