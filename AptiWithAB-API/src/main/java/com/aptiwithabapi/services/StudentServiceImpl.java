package com.aptiwithabapi.services;

import java.util.List;

import com.aptiwithabapi.daos.StudentDao;
import com.aptiwithabapi.daos.StudentDaoImpl;
import com.aptiwithabapi.exceptions.DataNotFoundException;
import com.aptiwithabapi.exceptions.DataUpdateFailedException;
import com.aptiwithabapi.models.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDao dao;
	
	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new StudentDaoImpl();
	}
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return dao.getAllStudents();
	}

	@Override
	public Student getStudentBy(int prn) {
		// TODO Auto-generated method stub
		Student student = dao.getStudentBy(prn);
		if (student == null) {
			throw new DataNotFoundException("Student with PRN " + prn + " does not exist.");
		}
		return student;
	}

	@Override
	public Student create(Student student) {
		// TODO Auto-generated method stub
		student = dao.create(student);
		if (student == null) {
			throw new DataUpdateFailedException("Resource creation failed.");
		}
		return student;
	}

	@Override
	public Student update(int prn, Student student) {
		// TODO Auto-generated method stub
		student = dao.update(prn, student);
		if (student == null) {
			throw new DataNotFoundException("Student with PRN " + prn + " does not exist.");
		}
		return student;
	}

	@Override
	public Student delete(int prn) {
		// TODO Auto-generated method stub
		Student student = dao.delete(prn);
		if (student == null) {
			throw new DataNotFoundException("Student with PRN " + prn + " does not exists.");
		}
		return student;
	}

	@Override
	public boolean deleteAllStudents() {
		// TODO Auto-generated method stub
		boolean status = dao.deleteAllStudents();
		if (!status) {
			throw new DataNotFoundException("There are no records to delete.");
		}
		return status;
	}

}
