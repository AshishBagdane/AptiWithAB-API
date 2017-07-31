package com.aptiwithabapi.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aptiwithabapi.models.Result;
import com.aptiwithabapi.utility.DatabaseConnection;

public class ResultDaoImpl implements ResultDao {

	@Override
	public List<Result> getAllResults() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM RESULT ORDER BY TID ASC, GRADE DESC";
		List<Result> results = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.isBeforeFirst()) {
				results = new ArrayList<>();
				while (resultSet.next()) {
					Result result = new Result();
					result.setId(resultSet.getLong(1));
					result.setStudentPRN(resultSet.getInt(2));
					result.setTestId(resultSet.getLong(3));
					result.setMarks(resultSet.getDouble(4));
					result.setGrade(resultSet.getString(5));
					result.setDate(resultSet.getDate(6));
					
					results.add(result);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public List<Result> getAllResultsForTest(long testId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM RESULT WHERE TID = ?";
		List<Result> results = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, testId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.isBeforeFirst()) {
				results = new ArrayList<>();
				while (resultSet.next()) {
					Result result = new Result();
					result.setId(resultSet.getLong(1));
					result.setStudentPRN(resultSet.getInt(2));
					result.setTestId(testId);
					result.setMarks(resultSet.getDouble(4));
					result.setGrade(resultSet.getString(5));
					result.setDate(resultSet.getDate(6));
					
					results.add(result);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public List<Result> getAllResultsForStudent(int prn) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM RESULT WHERE PRN = ?";
		List<Result> results = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, prn);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.isBeforeFirst()) {
				results = new ArrayList<>();
				while (resultSet.next()) {
					Result result = new Result();
					result.setId(resultSet.getLong(1));
					result.setStudentPRN(prn);
					result.setTestId(resultSet.getLong(3));
					result.setMarks(resultSet.getDouble(4));
					result.setGrade(resultSet.getString(5));
					result.setDate(resultSet.getDate(6));
					
					results.add(result);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public Result create(Result result) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO RESULT VALUES (result_seq.NEXT_VAL, ?, ?, ?, ?, ?)";
		Result createdResult = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, result.getStudentPRN());
			statement.setLong(2, result.getTestId());
			statement.setDouble(3, result.getMarks());
			statement.setString(4, result.getGrade());
			statement.setDate(5, (Date) result.getDate());
			if (statement.executeUpdate() > 0) {
				createdResult = result;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return createdResult;
	}

	@Override
	public boolean deleteAllResults() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM RESULT";
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

	@Override
	public boolean deleteAllResultsForTest(long testId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM RESULT WHERE TID = ?";
		boolean status = false;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, testId);
			status = (statement.executeUpdate() > 0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean deleteAllResultsForStudent(int prn) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM RESULT WHERE PRN = ?";
		boolean status = false;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, prn);
			status = (statement.executeUpdate() > 0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

}
