package com.aptiwithabapi.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aptiwithabapi.models.Test;
import com.aptiwithabapi.utility.DatabaseConnection;

public class TestDaoImpl implements TestDao {

	@Override
	public List<Test> getAllTets() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM TEST";
		List<Test> tests = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.isBeforeFirst()) {
				tests = new ArrayList<>();
				while (resultSet.next()) {
					Test test = new Test();
					test.setId(resultSet.getLong(1));
					test.setName(resultSet.getString(2));
					test.setCreatedBy(resultSet.getString(3));
					test.setDuration(resultSet.getInt(4));
					test.setNoOfQuestions(resultSet.getInt(5));
					
					tests.add(test);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tests;
	}

	@Override
	public Test getTestBy(long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM TEST WHERE ID = ?";
		Test test = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				test = new Test();
				test.setId(resultSet.getLong(1));
				test.setName(resultSet.getString(2));
				test.setCreatedBy(resultSet.getString(3));
				test.setDuration(resultSet.getInt(4));
				test.setNoOfQuestions(resultSet.getInt(5));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return test;
	}

	@Override
	public Test create(Test test) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO TEST VALUES (test_seq.NEXTVAL, ?, ?, ?, ?)";
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, test.getName());
			statement.setInt(2, test.getDuration());
			statement.setInt(3, test.getNoOfQuestions());
			statement.setString(4, test.getCreatedBy());
			if (statement.executeUpdate() <= 0) {
				test = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return test;
	}

	@Override
	public Test update(long id, Test test) {
		// TODO Auto-generated method stub
		String sql = "UPDATE TEST SET NAME = ?, CREATEDBY = ?, DURATION = ?, NOOFQUESTIONS = ? WHERE ID = ?";
		if (getTestBy(id) != null) {
			try (Connection connection = DatabaseConnection.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, test.getName());
				statement.setString(2, test.getCreatedBy());
				statement.setInt(3, test.getDuration());
				statement.setInt(4, test.getNoOfQuestions());
				statement.setLong(5, test.getId());
				if (statement.executeUpdate() <= 0) {
					test = null;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return test;
	}

	@Override
	public Test delete(long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM TEST WHERE ID = ?";
		Test test = getTestBy(id);
		if (test != null) {
			try (Connection connection = DatabaseConnection.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, id);
				if (statement.executeUpdate() <= 0) {
					test = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return test;
	}

	@Override
	public boolean deleteAllTests() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM TEST";
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
