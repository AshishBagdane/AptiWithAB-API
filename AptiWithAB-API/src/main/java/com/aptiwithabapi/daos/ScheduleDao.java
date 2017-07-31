package com.aptiwithabapi.daos;

import java.util.List;

import com.aptiwithabapi.models.Schedule;

public interface ScheduleDao {

	List<Schedule>	getAllSchedulesFor(long testId);
	Schedule		getScheduleFor(long testId, long scheduleId);
	Schedule		create(Schedule schedule);
	Schedule		update(long scheduleId, Schedule schedule);
	boolean			deleteAllSchedulesFor(long testId);
	Schedule		deleteSchedule(long scheduleId);
}
