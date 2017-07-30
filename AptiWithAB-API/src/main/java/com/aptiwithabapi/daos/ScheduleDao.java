package com.aptiwithabapi.daos;

import java.util.List;

import com.aptiwithabapi.models.Schedule;

public interface ScheduleDao {

	List<Schedule>	getAllSchedulesFor(int testId);
	Schedule		getScheduleFor(int testId, int scheduleId);
	Schedule		create(Schedule schedule);
	Schedule		update(int scheduleId, Schedule schedule);
	boolean			deleteAllSchedulesFor(int testId);
	Schedule		deleteSchedule(int scheduleId);
}
