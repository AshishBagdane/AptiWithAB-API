package com.aptiwithabapi.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aptiwithabapi.models.FetchQuestion;
import com.aptiwithabapi.models.Question;
import com.aptiwithabapi.utility.DatabaseConnection;

public class FetchQuestionDaoImpl implements FetchQuestionDao {

	@Override
	public List<Question> getAllQuestionsFor(long testId) {
		// TODO Auto-generated method stub
		String sql = "SELECT Q.NO, Q.TYPE, Q.STATEMENT, Q.ANSWER, FQ.MARKS FROM QUESTION Q, FETCH_QUESTION FQ WHERE Q.NO = FQ.NO AND FQ.TID = ?";
		List<Question> questions = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, testId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.isBeforeFirst()) {
				questions = new ArrayList<>();
				while (resultSet.next()) {
					Question question = new Question();
					question.setNo(resultSet.getInt(1));
					question.setType(resultSet.getString(2));
					question.setStatement(resultSet.getString(3));
					question.setAnswer(resultSet.getString(4));
					question.setMarks(resultSet.getInt(5));
					question.setOptions(new OptionsDaoImpl().getAllOptionsFor(question.getNo()));
					
					questions.add(question);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return questions;
	}

	@Override
	public Question getQuestionFor(long testId, long qnumber) {
		// TODO Auto-generated method stub
		String sql = "SELECT Q.NO, Q.TYPE, Q.STATEMENT, Q.ANSWER, FQ.MARKS FROM QUESTION Q, FETCH_QUESTION FQ WHERE Q.NO = FQ.NO AND FQ.TID = ? AND FQ.NO = ?";
		Question question = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, testId);
			statement.setLong(2, qnumber);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				question = new Question();
				question.setNo(resultSet.getInt(1));
				question.setType(resultSet.getString(2));
				question.setStatement(resultSet.getString(3));
				question.setAnswer(resultSet.getString(4));
				question.setMarks(resultSet.getInt(5));
				question.setOptions(new OptionsDaoImpl().getAllOptionsFor(question.getNo()));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return question;
	}

	@Override
	public FetchQuestion create(FetchQuestion fetchQuestion) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO FETCH_QUESTION VALUES (fetchquestion_seq.NEXTVAL, ?, ?, ?);";
		FetchQuestion createdFetchQuestion = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, fetchQuestion.getTestId());
			statement.setLong(2, fetchQuestion.getQuestionNo());
			statement.setInt(3, fetchQuestion.getMarks());
			if (statement.executeUpdate() > 0) {
				createdFetchQuestion = fetchQuestion;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return createdFetchQuestion;
	}

	@Override
	public FetchQuestion update(long testId, long qnumber, FetchQuestion fetchQuestion) {
		// TODO Auto-generated method stub
		String sql = "UPDATE FETCH_QUESTION SET MARKS = ? WHERE TID = ? AND NO = ?";
		FetchQuestion updatedFetchQuestion = null;
		if (getFetchQuestionFrom(testId, qnumber) != null) {
			try (Connection connection = DatabaseConnection.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, testId);
				statement.setLong(2, qnumber);
				statement.setInt(3, fetchQuestion.getMarks());
				if (statement.executeUpdate() > 0) {
					updatedFetchQuestion = fetchQuestion;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return updatedFetchQuestion;
	}

	@Override
	public boolean deleteAllQuestionsFrom(long testId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM FETCH_QUESTION WHERE TID = ?";
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
	public FetchQuestion deleteQuestionFrom(long testId, long qnumber) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM FETCH_QUESTION WHERE TID = ? AND NO = ?";
		FetchQuestion deletedFetchQuestion = getFetchQuestionFrom(testId, qnumber);
		if (deletedFetchQuestion != null) {
			try (Connection connection = DatabaseConnection.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, testId);
				statement.setLong(2, qnumber);
				if (statement.executeUpdate() <= 0) {
					deletedFetchQuestion = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return deletedFetchQuestion;
	}
	
	private FetchQuestion getFetchQuestionFrom(long testId, long qnumber) {
		String sql = "SELECT * FROM FETCH_QUESTION WHERE TID = ? AND NO = ?";
		FetchQuestion fetchQuestion = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, testId);
			statement.setLong(2, qnumber);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				fetchQuestion = new FetchQuestion();
				fetchQuestion.setId(resultSet.getInt(1));
				fetchQuestion.setTestId(testId);
				fetchQuestion.setQuestionNo(qnumber);
				fetchQuestion.setMarks(resultSet.getByte(4));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fetchQuestion;
	}

}
