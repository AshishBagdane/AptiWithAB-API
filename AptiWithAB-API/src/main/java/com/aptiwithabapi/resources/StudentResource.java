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

import com.aptiwithabapi.models.Student;
import com.aptiwithabapi.services.StudentService;
import com.aptiwithabapi.services.StudentServiceImpl;
import com.aptiwithabapi.utility.GetResponse;

@Path("/students")
@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class StudentResource {

	private StudentService service;
	
	public StudentResource() {
		// TODO Auto-generated constructor stub
		service = new StudentServiceImpl();
	}
	
	@GET
	public Response getAllStudents() {
		List<Student> students = service.getAllStudents();
		Response response = GetResponse.forFound(students.toArray(new Student[students.size()]));
		return response;
	}
	
	@GET
	@Path("/{prn}")
	public Response getStudentBy(@PathParam("prn") int prn) {
		Student student = service.getStudentBy(prn);
		Response response = GetResponse.forFound(student);
		return response;
	}
	
	@POST
	public Response create(Student student) {
		student = service.create(student);
		Response response = GetResponse.forCreated(student);
		return response;
	}
	
	@PUT
	@Path("/{prn}")
	public Response update(@PathParam("prn") int prn, Student student) {
		student = service.update(prn, student);
		Response response = GetResponse.forOk(student);
		return response;
	}
	
	@DELETE
	@Path("/{prn}")
	public Response delete(@PathParam("prn") int prn) {
		Student student = service.delete(prn);
		Response response = GetResponse.forOk(student);
		return response;
	}
	
	@DELETE
	public Response deleteAllStudents() {
		boolean status = service.deleteAllStudents();
		Response response = GetResponse.forOk(status);
		return response;
	}
}
