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

import com.aptiwithabapi.models.Question;
import com.aptiwithabapi.services.QuestionService;
import com.aptiwithabapi.services.QuestionServiceImpl;
import com.aptiwithabapi.utility.GetResponse;

@Path("/questions")
@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class QuestionResource {

	private QuestionService service;
	
	public QuestionResource() {
		// TODO Auto-generated constructor stub
		service = new QuestionServiceImpl();
	}
	
	@GET
	public Response getAllQuestions() {
		List<Question> questions = service.getAllQuestions();
		Response response = GetResponse.forFound(questions);
		return response;
	}
	
	@GET
	@Path("/{qnumber}")
	public Response getQuestionFor(@PathParam("qnumber") long qnumber) {
		Question question = service.getQuestionFor(qnumber);
		Response response = GetResponse.forFound(question);
		return response;
	}
	
	@POST
	public Response create(Question question) {
		question = service.create(question);
		Response response = GetResponse.forCreated(question);
		return response;
	}
	
	@PUT
	@Path("/{qnumber}")
	public Response update(@PathParam("qnumber") long qnumber, Question question) {
		question = service.update(qnumber, question);
		Response response = GetResponse.forOk(question);
		return response;
	}
	
	@DELETE
	@Path("/{qnumber}")
	public Response delete(@PathParam("qnumber") long qnumber) {
		Question question = service.delete(qnumber);
		Response response = GetResponse.forOk(question);
		return response;
	}
	
	@DELETE
	public Response delete() {
		boolean status = service.delete();
		Response response = GetResponse.forOk(status);
		return response;
	}
	
	@Path("/options")
	public OptionResource getOptionResource() {
		return new OptionResource();
	}
}
