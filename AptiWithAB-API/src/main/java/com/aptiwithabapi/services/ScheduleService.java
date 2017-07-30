package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.models.Schedule;

public interface ScheduleService {

	List<Schedule>	getAllSchedulesFor(int testId);
	Schedule		getScheduleFor(int testId, int scheduleId);
	Schedule		create(Schedule schedule);
	Schedule		update(int scheduleId, Schedule schedule);
	boolean			deleteAllSchedulesFor(int testId);
	Schedule		deleteSchedule(int scheduleId);
}
