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

import com.aptiwithabapi.models.Result;
import com.aptiwithabapi.models.Test;
import com.aptiwithabapi.services.ResultServiceImpl;
import com.aptiwithabapi.services.TestService;
import com.aptiwithabapi.services.TestServiceImpl;
import com.aptiwithabapi.utility.GetResponse;

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
	public Response getAllTests() {
		List<Test> tests = service.getAllTets();
		Response response = GetResponse.forFound(tests);
		return response;
	}
	
	@GET
	@Path("/{testId}")
	public Response getTestBy(@PathParam("testId") long testId) {
		Test test = service.getTestBy(testId);
		Response response = GetResponse.forFound(test);
		return response;
	}
	
	@POST
	public Response create(Test test) {
		test = service.create(test);
		Response response = GetResponse.forCreated(test);
		return response;
	}
	
	@PUT
	@Path("/{testId}")
	public Response update(@PathParam("testId") long testId, Test test) {
		test = service.update(testId, test);
		Response response = GetResponse.forOk(test);
		return response;
	}
	
	@DELETE
	public Response deleteAllTests() {
		boolean status = service.deleteAllTests();
		Response response = GetResponse.forOk(status);
		return response;
	}
	
	@DELETE
	@Path("/{testId}")
	public Response delete(@PathParam("testId") long testId) {
		Test test = service.delete(testId);
		Response response = GetResponse.forOk(test);
		return response;
	}
	
	@Path("/{testId}/schedules")
	public ScheduleResource getScheduleResource() {
		return new ScheduleResource();
	}
	
	@Path("/{testId}/fetch")
	public FetchQuestionResource getFetchQuestionResource() {
		return new FetchQuestionResource();
	}
	
	@GET
	@Path("/{testId}/results")
	public Response getAllResultsForStudent(@PathParam("testId") long testId) {
		List<Result> results = new ResultServiceImpl().getAllResultsForTest(testId);
		Response response = GetResponse.forFound(results.toArray(new Result[results.size()]));
		return response;
	}
}
