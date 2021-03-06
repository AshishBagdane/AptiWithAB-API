package com.aptiwithabapi.daos;

import java.util.List;

import com.aptiwithabapi.models.Student;

public interface StudentDao {

	List<Student> getAllStudents();
	Student getStudentBy(int prn);
	Student create(Student student);
	Student update(int prn, Student student);
	Student delete(int prn);
	boolean deleteAllStudents();
}
