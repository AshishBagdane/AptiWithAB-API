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

import com.aptiwithabapi.models.Option;
import com.aptiwithabapi.services.OptionsService;
import com.aptiwithabapi.services.OptionsServiceImpl;
import com.aptiwithabapi.utility.GetResponse;

@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class OptionResource {

	private OptionsService service;
	
	public OptionResource() {
		// TODO Auto-generated constructor stub
		service = new OptionsServiceImpl();
	}
	
	@GET
	public Response getAllOptionsFor(@PathParam("qnumber") long qnumber) {
		List<Option> options = service.getAllOptionsFor(qnumber);
		Response response = GetResponse.forFound(options.toArray(new Option[options.size()]));
		return response;
	}
	
	@GET
	@Path("/{optnumber}")
	public Response getOptionFor(@PathParam("qnumber") long qnumber, @PathParam("optnumber") int optnumber) {
		Option option = service.getOptionFor(qnumber, optnumber);
		Response response = GetResponse.forFound(option);
		return response;
	}
	
	@POST
	public Response create(List<Option> options) {
		options = service.create(options);
		Response response = GetResponse.forCreated(options);
		return response;
	}
	
	@PUT
	@Path("/{optnumber}")
	public Response update(@PathParam("qnumber") long qnumber, @PathParam("optnumber") int optnumber, Option option) {
		option = service.update(qnumber, optnumber, option);
		Response response = GetResponse.forOk(option);
		return response;
	}
	
	@DELETE
	public Response delete(@PathParam("qnumber") long qnumber) {
		boolean status = service.delete(qnumber);
		Response response = GetResponse.forOk(status);
		return response;
	}
	
	@DELETE
	@Path("/{optnumber}")
	public Response delete(@PathParam("qnumber") long qnumber, @PathParam("optnumber") int optnumber) {
		Option option = service.delete(qnumber, optnumber);
		Response response = GetResponse.forOk(option);
		return response;
	}
}
