package com.aptiwithabapi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.aptiwithabapi.models.Result;
import com.aptiwithabapi.services.ResultService;
import com.aptiwithabapi.services.ResultServiceImpl;
import com.aptiwithabapi.utility.GetResponse;

@Path("/results")
@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class ResultResource {

	private ResultService service;
	
	public ResultResource() {
		// TODO Auto-generated constructor stub
		service = new ResultServiceImpl();
	}
	
	@GET
	public Response getAllResults() {
		List<Result> results = service.getAllResults();
		Response response = GetResponse.forFound(results.toArray(new Result[results.size()]));
		return response;
	}
	
	@POST
	public Response create(Result result) {
		result = service.create(result);
		Response response = GetResponse.forCreated(result);
		return response;
	}
	
	public Response deleteAllResults() {
		boolean status = service.deleteAllResults();
		Response response = GetResponse.forOk(status);
		return response;
	}
}