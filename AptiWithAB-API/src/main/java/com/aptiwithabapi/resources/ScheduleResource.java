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
import javax.ws.rs.core.Response;

import com.aptiwithabapi.models.Schedule;
import com.aptiwithabapi.services.ScheduleService;
import com.aptiwithabapi.services.ScheduleServiceImpl;
import com.aptiwithabapi.utility.GetResponse;

@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class ScheduleResource {

	private ScheduleService service;
	
	public ScheduleResource() {
		// TODO Auto-generated constructor stub
		service = new ScheduleServiceImpl();
	}
	
	@GET
	public Response getAllSchedulesFor(@PathParam("testId") long testId) {
		List<Schedule> schedules = service.getAllSchedulesFor(testId);
		Response response = GetResponse.forFound(schedules);
		return response;
	}
	
	@GET
	@Path("/{scheduleId}")
	public Response getScheduleFor(@PathParam("testId") long testId, @PathParam("scheduleId") long scheduleId) {
		Schedule schedule = service.getScheduleFor(testId, scheduleId);
		Response response = GetResponse.forFound(schedule);
		return response;
	}
	
	@POST
	public Response create(Schedule schedule) {
		schedule = service.create(schedule);
		Response response = GetResponse.forCreated(schedule);
		return response;
	}
	
	@PUT
	@Path("/{scheduleId}")
	public Response update(@PathParam("scheduleId") long scheduleId, Schedule schedule) {
		schedule = service.update(scheduleId, schedule);
		Response response = GetResponse.forOk(schedule);
		return response;
	}
	
	@DELETE
	public Response deleteAllSchedulesFor(@PathParam("testId") long testId) {
		boolean status = service.deleteAllSchedulesFor(testId);
		Response response = GetResponse.forOk(status);
		return response;
	}
	
	@DELETE
	@Path("/{scheduleId}")
	public Response deleteSchedule(@PathParam("scheduleId") long scheduleId) {
		Schedule schedule = service.deleteSchedule(scheduleId);
		Response response = GetResponse.forOk(schedule);
		return response;
	}
}
