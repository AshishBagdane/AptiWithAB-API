package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.models.Schedule;

public interface ScheduleService {

	List<Schedule>	getAllSchedulesFor(long testId);
	Schedule		getScheduleFor(long testId, long scheduleId);
	Schedule		create(Schedule schedule);
	Schedule		update(long scheduleId, Schedule schedule);
	boolean			deleteAllSchedulesFor(long testId);
	Schedule		deleteSchedule(long scheduleId);
}
