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

import com.aptiwithabapi.models.Student;
import com.aptiwithabapi.services.StudentService;
import com.aptiwithabapi.services.StudentServiceImpl;

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
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}
	
	@GET
	@Path("/{prn}")
	public Student getStudentBy(@PathParam("prn") int prn) {
		return service.getStudentBy(prn);
	}
	
	@POST
	public Student create(Student student) {
		return service.create(student);
	}
	
	@PUT
	@Path("/{prn}")
	public Student update(@PathParam("prn") int prn, Student student) {
		return service.update(prn, student);
	}
	
	@DELETE
	@Path("/{prn}")
	public Student delete(@PathParam("prn") int prn) {
		return service.delete(prn);
	}
	
	@DELETE
	public boolean deleteAllStudents() {
		return service.deleteAllStudents();
	}
}
