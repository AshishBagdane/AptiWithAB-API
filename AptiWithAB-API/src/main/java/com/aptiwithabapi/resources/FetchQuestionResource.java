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

import com.aptiwithabapi.models.FetchQuestion;
import com.aptiwithabapi.models.Question;
import com.aptiwithabapi.services.FetchQuestionService;
import com.aptiwithabapi.services.FetchQuestionServiceImpl;
import com.aptiwithabapi.utility.GetResponse;

@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class FetchQuestionResource {

	private FetchQuestionService service;
	
	public FetchQuestionResource() {
		// TODO Auto-generated constructor stub
		service = new FetchQuestionServiceImpl();
	}
	
	@GET
	public Response getAllQuestionsFor(@PathParam("testId") long testId) {
		List<Question> questions = service.getAllQuestionsFor(testId);
		Response response = GetResponse.forFound(questions.toArray(new Question[questions.size()]));
		return response;
	}
	
	@GET
	@Path("/{qnumber}")
	public Response getQuestionFor(@PathParam("testId") long testId, @PathParam("qnumber") long qnumber) {
		Question question = service.getQuestionFor(testId, qnumber);
		Response response = GetResponse.forFound(question);
		return response;
	}
	
	@POST
	public Response create(FetchQuestion fetchQuestion) {
		fetchQuestion = service.create(fetchQuestion); 
		Response response = GetResponse.forCreated(fetchQuestion);
		return response;
	}
	
	@PUT
	@Path("/{qnumber}")
	public Response update(@PathParam("testId") long testId, @PathParam("qnumber") long qnumber, FetchQuestion fetchQuestion) {
		fetchQuestion = service.update(testId, qnumber, fetchQuestion);
		Response response = GetResponse.forOk(fetchQuestion);
		return response;
	}
	
	@DELETE
	public Response deleteAllQuestionsFrom(@PathParam("testId") long testId) {
		boolean status = service.deleteAllQuestionsFrom(testId);
		Response response = GetResponse.forOk(status);
		return response;
	}
	
	@DELETE
	@Path("/{qnumber}")
	public Response deleteQuestionFrom(@PathParam("testId") long testId, @PathParam("qnumber") long qnumber) {
		FetchQuestion fetchQuestion = service.deleteQuestionFrom(testId, qnumber);
		Response response = GetResponse.forCreated(fetchQuestion);
		return response;
	}
}
