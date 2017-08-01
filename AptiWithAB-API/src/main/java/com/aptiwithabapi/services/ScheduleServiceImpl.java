package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.ScheduleDao;
import com.aptiwithabapi.daos.ScheduleDaoImpl;
import com.aptiwithabapi.exceptions.DataNotFoundException;
import com.aptiwithabapi.exceptions.DataUpdateFailedException;
import com.aptiwithabapi.models.Schedule;

public class ScheduleServiceImpl implements ScheduleService {

	private ScheduleDao dao;
	
	public ScheduleServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new ScheduleDaoImpl();
	}
	
	@Override
	public List<Schedule> getAllSchedulesFor(long testId) {
		// TODO Auto-generated method stub
		List<Schedule> schedules = dao.getAllSchedulesFor(testId);
		if (schedules == null) {
			throw new DataNotFoundException("There are no records associated with Test " + testId);
		}
		return schedules;
	}

	@Override
	public Schedule getScheduleFor(long testId, long scheduleId) {
		// TODO Auto-generated method stub
		Schedule schedule = dao.getScheduleFor(testId, scheduleId);
		if (schedule == null) {
			throw new DataNotFoundException("No such schedule exists.");
		}
		return schedule;
	}

	@Override
	public Schedule create(Schedule schedule) {
		// TODO Auto-generated method stub
		schedule = dao.create(schedule);
		if (schedule == null) {
			throw new DataUpdateFailedException("Resource creation failed.");
		}
		return schedule;
	}

	@Override
	public Schedule update(long scheduleId, Schedule schedule) {
		// TODO Auto-generated method stub
		schedule = dao.update(scheduleId, schedule);
		if (schedule == null) {
			throw new DataNotFoundException("Schedule with Id " + scheduleId + " does not exist.");
		}
		return schedule;
	}

	@Override
	public boolean deleteAllSchedulesFor(long testId) {
		// TODO Auto-generated method stub
		boolean status = dao.deleteAllSchedulesFor(testId);
		if (!status) {
			throw new DataNotFoundException("There are no records associated with Test " + testId + ".");
		}
		return status;
	}

	@Override
	public Schedule deleteSchedule(long scheduleId) {
		// TODO Auto-generated method stub
		Schedule schedule = dao.deleteSchedule(scheduleId);
		if (schedule == null) {
			throw new DataNotFoundException("No such schedule exists.");
		}
		return schedule;
	}

}
