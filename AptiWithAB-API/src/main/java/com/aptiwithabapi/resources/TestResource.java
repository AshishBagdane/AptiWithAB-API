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

import com.aptiwithabapi.models.Test;
import com.aptiwithabapi.services.TestService;
import com.aptiwithabapi.services.TestServiceImpl;

@Path("/tests")
@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class TestResource {
	
	private TestService service;
	
	public TestResource() {
		// TODO Auto-generated constructor stub
		service = new TestServiceImpl();
	}

	@GET
	public List<Test> getAllTests() {
		return service.getAllTets();
	}
	
	@GET
	@Path("/{testId}")
	public Test getTestBy(@PathParam("testId") long testId) {
		return service.getTestBy(testId);
	}
	
	@POST
	public Test create(Test test) {
		return service.create(test);
	}
	
	@PUT
	@Path("/{testId}")
	public Test update(@PathParam("testId") long testId, Test test) {
		return service.update(testId, test);
	}
	
	@DELETE
	public boolean deleteAllTests() {
		return service.deleteAllTests();
	}
	
	@DELETE
	@Path("/{testId}")
	public Test delete(@PathParam("testId") long testId) {
		return service.delete(testId);
	}
	
	@Path("/schedules")
	public ScheduleResource getScheduleResource() {
		return new ScheduleResource();
	}
	
	@Path("/fetch")
	public FetchQuestionResource getFetchQuestionResource() {
		return new FetchQuestionResource();
	}
}
