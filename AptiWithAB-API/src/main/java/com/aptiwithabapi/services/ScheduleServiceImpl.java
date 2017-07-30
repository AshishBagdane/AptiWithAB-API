package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.ScheduleDao;
import com.aptiwithabapi.daos.ScheduleDaoImpl;
import com.aptiwithabapi.models.Schedule;

public class ScheduleServiceImpl implements ScheduleService {

	private ScheduleDao dao;
	
	public ScheduleServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new ScheduleDaoImpl();
	}
	
	@Override
	public List<Schedule> getAllSchedulesFor(int testId) {
		// TODO Auto-generated method stub
		List<Schedule> schedules = dao.getAllSchedulesFor(testId);
		if (schedules == null) {
			
		}
		return schedules;
	}

	@Override
	public Schedule getScheduleFor(int testId, int scheduleId) {
		// TODO Auto-generated method stub
		Schedule schedule = dao.getScheduleFor(testId, scheduleId);
		if (schedule == null) {
			
		}
		return schedule;
	}

	@Override
	public Schedule create(Schedule schedule) {
		// TODO Auto-generated method stub
		schedule = dao.create(schedule);
		if (schedule == null) {
			
		}
		return schedule;
	}

	@Override
	public Schedule update(int scheduleId, Schedule schedule) {
		// TODO Auto-generated method stub
		schedule = dao.update(scheduleId, schedule);
		if (schedule == null) {
			
		}
		return schedule;
	}

	@Override
	public boolean deleteAllSchedulesFor(int testId) {
		// TODO Auto-generated method stub
		boolean status = dao.deleteAllSchedulesFor(testId);
		if (!status) {
			
		}
		return status;
	}

	@Override
	public Schedule deleteSchedule(int scheduleId) {
		// TODO Auto-generated method stub
		Schedule schedule = dao.deleteSchedule(scheduleId);
		if (schedule == null) {
			
		}
		return schedule;
	}

}
