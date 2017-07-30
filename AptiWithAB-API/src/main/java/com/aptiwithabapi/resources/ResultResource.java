package com.aptiwithabapi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aptiwithabapi.models.Result;
import com.aptiwithabapi.services.ResultService;
import com.aptiwithabapi.services.ResultServiceImpl;

@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class ResultResource {

	private ResultService service;
	
	public ResultResource() {
		// TODO Auto-generated constructor stub
		service = new ResultServiceImpl();
	}
	
	@GET
	public List<Result> getAllResults() {
		return service.getAllResults();
	}
	
	@POST
	public Result create(Result result) {
		return service.create(result);
	}
	
	@DELETE
	public boolean deleteAllResults() {
		return service.deleteAllResults();
	}
}
