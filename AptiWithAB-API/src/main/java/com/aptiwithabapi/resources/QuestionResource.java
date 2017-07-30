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

import com.aptiwithabapi.models.Question;
import com.aptiwithabapi.services.QuestionService;
import com.aptiwithabapi.services.QuestionServiceImpl;

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
	public List<Question> getAllQuestions() {
		return service.getAllQuestions();
	}
	
	@GET
	@Path("/{qnumber}")
	public Question getQuestionFor(@PathParam("qnumber") int qnumber) {
		return service.getQuestionFor(qnumber);
	}
	
	@POST
	public Question create(Question question) {
		return service.create(question);
	}
	
	@PUT
	@Path("/{qnumber}")
	public Question update(@PathParam("qnumber") int qnumber, Question question) {
		return service.update(qnumber, question);
	}
	
	@DELETE
	@Path("/{qnumber}")
	public Question delete(@PathParam("qnumber") int qnumber) {
		return service.delete(qnumber);
	}
	
	@DELETE
	public boolean delete() {
		return service.delete();
	}
	
	@Path("/options")
	public OptionResource getOptionResource() {
		return new OptionResource();
	}
}
