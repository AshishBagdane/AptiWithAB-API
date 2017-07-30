package com.aptiwithabapi.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aptiwithabapi.models.Student;
import com.aptiwithabapi.utility.DatabaseConnection;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM STUDENT";
		List<Student> students = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			students = new ArrayList<>();
			while (resultSet.next()) {
				Student student = new Student();
				student.setPRN(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setBranch(resultSet.getString(3));
				student.setEmail(resultSet.getString(4));
				student.setContactNo(resultSet.getLong(5));
				student.setPassword(resultSet.getString(6));
				
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student getStudentBy(int prn) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM STUDENT WHERE PRN = ?";
		Student student = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, prn);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				student = new Student();
				student.setPRN(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setBranch(resultSet.getString(3));
				student.setEmail(resultSet.getString(4));
				student.setContactNo(resultSet.getLong(5));
				student.setPassword(resultSet.getString(6));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public Student create(Student student) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO STUDENT VALUES (?, ?, ?, ?, ?, ?)";
		Student createdStudent = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, student.getPRN());
			statement.setString(2, student.getName());
			statement.setString(3, student.getBranch());
			statement.setString(4, student.getEmail());
			statement.setLong(5, student.getContactNo());
			statement.setString(6, student.getPassword());
			if (statement.executeUpdate() > 0) {
				createdStudent = student;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return createdStudent;
	}

	@Override
	public Student update(int prn, Student student) {
		// TODO Auto-generated method stub
		String sql = "UPDATE STUDENT SET NAME = ?, BRANCH = ?, EMAIL = ?, CONTACTNO = ?, PASSWORD = ? WHERE PRN = ?";
		Student updatedStudent = null;
		if (getStudentBy(prn) != null) {
			try (Connection connection = DatabaseConnection.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, student.getPRN());
				statement.setString(2, student.getName());
				statement.setString(3, student.getBranch());
				statement.setString(4, student.getEmail());
				statement.setLong(5, student.getContactNo());
				statement.setString(6, student.getPassword());
				if (statement.executeUpdate() > 0) {
					updatedStudent = student;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return updatedStudent;
	}

	@Override
	public Student delete(int prn) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM STUDENT WHERE PRN = ?";
		Student deletedStudent = getStudentBy(prn);
		if (deletedStudent != null) {
			try (Connection connection = DatabaseConnection.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, prn);
				if (statement.executeUpdate() <= 0) {
					deletedStudent = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return deletedStudent;
	}

	@Override
	public boolean deleteAllStudents() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM STUDENT";
		boolean status = false;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			status = (statement.executeUpdate() > 0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

}
