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

import com.aptiwithabapi.models.Option;
import com.aptiwithabapi.services.OptionsService;
import com.aptiwithabapi.services.OptionsServiceImpl;

@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class OptionResource {

	private OptionsService service;
	
	public OptionResource() {
		// TODO Auto-generated constructor stub
		service = new OptionsServiceImpl();
	}
	
	@GET
	public List<Option> getAllOptionsFor(@PathParam("qnumber") long qnumber) {
		return service.getAllOptionsFor(qnumber);
	}
	
	@GET
	@Path("/{optnumber}")
	public Option getOptionFor(@PathParam("qnumber") long qnumber, @PathParam("optnumber") int optnumber) {
		return service.getOptionFor(qnumber, optnumber);
	}
	
	@POST
	public List<Option> create(List<Option> options) {
		return service.create(options);
	}
	
	@PUT
	@Path("/{optnumber}")
	public Option update(@PathParam("qnumber") long qnumber, @PathParam("optnumber") int optnumber, Option option) {
		return service.update(qnumber, optnumber, option);
	}
	
	@DELETE
	public boolean delete(@PathParam("qnumber") long qnumber) {
		return service.delete(qnumber);
	}
	
	@DELETE
	@Path("/{optnumber}")
	public Option delete(@PathParam("qnumber") long qnumber, @PathParam("optnumber") int optnumber) {
		return service.delete(qnumber, optnumber);
	}
}
