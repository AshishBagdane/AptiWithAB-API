package com.aptiwithabapi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aptiwithabapi.models.Schedule;
import com.aptiwithabapi.services.ScheduleService;
import com.aptiwithabapi.services.ScheduleServiceImpl;

@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class ScheduleResource {

	private ScheduleService service;
	
	public ScheduleResource() {
		// TODO Auto-generated constructor stub
		service = new ScheduleServiceImpl();
	}
	
	@GET
	public List<Schedule> getAllSchedulesFor(@PathParam("testId") int testId) {
		return service.getAllSchedulesFor(testId);
	}
	
	@GET
	@Path("/{scheduleId}")
	public Schedule getScheduleFor(@PathParam("testId") int testId, @PathParam("scheduleId") int scheduleId) {
		return service.getScheduleFor(testId, scheduleId);
	}
	
	@POST
	public Schedule create(Schedule schedule) {
		return service.create(schedule);
	}
	
	@PUT
	@Path("/{scheduleId}")
	public Schedule update(@PathParam("scheduleId") int scheduleId, Schedule schedule) {
		return service.update(scheduleId, schedule);
	}
	
	@DELETE
	public boolean deleteAllSchedulesFor(@PathParam("testId") int testId) {
		return service.deleteAllSchedulesFor(testId);
	}
	
	@DELETE
	@Path("/{scheduleId}")
	public Schedule deleteSchedule(@PathParam("scheduleId") int scheduleId) {
		return service.deleteSchedule(scheduleId);
	}
}
