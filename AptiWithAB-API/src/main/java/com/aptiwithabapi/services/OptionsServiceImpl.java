package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.OptionsDao;
import com.aptiwithabapi.daos.OptionsDaoImpl;
import com.aptiwithabapi.models.Option;

public class OptionsServiceImpl implements OptionsService {

	private OptionsDao dao;
	
	public OptionsServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new OptionsDaoImpl();
	}
	
	@Override
	public List<Option> getAllOptionsFor(int qnumber) {
		// TODO Auto-generated method stub
		List<Option> options = dao.getAllOptionsFor(qnumber);
		if (options == null) {
			
		}
		return options;
	}

	@Override
	public Option getOptionFor(int qnumber, int optnumber) {
		// TODO Auto-generated method stub
		Option option = dao.getOptionFor(qnumber, optnumber);
		if (option == null) {
			
		}
		return null;
	}

	@Override
	public List<Option> create(List<Option> options) {
		// TODO Auto-generated method stub
		options = dao.create(options);
		if (options == null) {
			
		}
		return options;
	}

	@Override
	public Option update(int qnumber, int optnumber, Option option) {
		// TODO Auto-generated method stub
		option = dao.update(qnumber, optnumber, option);
		if (option == null) {
			
		}
		return option;
	}

	@Override
	public boolean delete(int qnumber) {
		// TODO Auto-generated method stub
		boolean status = dao.delete(qnumber);
		if (!status) {
			
		}
		return status;
	}

	@Override
	public Option delete(int qnumber, int optnumber) {
		// TODO Auto-generated method stub
		Option option = dao.delete(qnumber, optnumber);
		if (option == null) {
			
		}
		return option;
	}
	
}
