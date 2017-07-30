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

import com.aptiwithabapi.models.FetchQuestion;
import com.aptiwithabapi.models.Question;
import com.aptiwithabapi.services.FetchQuestionService;
import com.aptiwithabapi.services.FetchQuestionServiceImpl;

@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class FetchQuestionResource {

	private FetchQuestionService service;
	
	public FetchQuestionResource() {
		// TODO Auto-generated constructor stub
		service = new FetchQuestionServiceImpl();
	}
	
	@GET
	public List<Question> getAllQuestionsFor(@PathParam("testId") int testId) {
		return service.getAllQuestionsFor(testId);
	}
	
	@GET
	@Path("/{qnumber}")
	public Question getQuestionFor(@PathParam("testId") int testId, @PathParam("qnumber") int qnumber) {
		return service.getQuestionFor(testId, qnumber);
	}
	
	@POST
	public FetchQuestion create(FetchQuestion fetchQuestion) {
		return service.create(fetchQuestion);
	}
	
	@PUT
	@Path("/{qnumber}")
	public FetchQuestion update(@PathParam("testId") int testId, @PathParam("qnumber") int qnumber, FetchQuestion fetchQuestion) {
		return service.update(testId, qnumber, fetchQuestion);
	}
	
	@DELETE
	public boolean deleteAllQuestionsFrom(@PathParam("testId") int testId) {
		return service.deleteAllQuestionsFrom(testId);
	}
	
	@DELETE
	@Path("/{qnumber}")
	public FetchQuestion deleteQuestionFrom(@PathParam("testId") int testId, @PathParam("qnumber") int qnumber) {
		return service.deleteQuestionFrom(testId, qnumber);
	}
}
