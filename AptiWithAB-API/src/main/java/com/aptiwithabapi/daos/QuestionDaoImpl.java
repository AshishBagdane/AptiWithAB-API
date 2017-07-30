package com.aptiwithabapi.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aptiwithabapi.models.Option;
import com.aptiwithabapi.models.Question;
import com.aptiwithabapi.utility.DatabaseConnection;

public class QuestionDaoImpl implements QuestionDao {

	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM QUESTION ORDER BY NO ASC, TYPE ASC";
		List<Question> questions = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			questions = new ArrayList<>();
			while (resultSet.next()) {
				Question question = new Question();
				question.setNo(resultSet.getInt(1));
				question.setType(resultSet.getString(2));
				question.setStatement(resultSet.getString(3));
				question.setAnswer(resultSet.getString(4));
				question.setImageURL(resultSet.getString(5));
				List<Option> options = new OptionsDaoImpl().getAllOptionsFor(question.getNo());
				if (options != null) {
					question.setOptions(options);
				}
				questions.add(question);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return questions;
	}

	@Override
	public Question getQuestionFor(int qnumber) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM QUESTION WHERE NO = ?";
		Question question = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				question = new Question();
				question.setNo(resultSet.getInt(1));
				question.setType(resultSet.getString(2));
				question.setStatement(resultSet.getString(3));
				question.setAnswer(resultSet.getString(4));
				question.setImageURL(resultSet.getString(5));
				List<Option> options = new OptionsDaoImpl().getAllOptionsFor(question.getNo());
				if (options != null) {
					question.setOptions(options);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return question;
	}

	@Override
	public Question create(Question question) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO QUESTION VALUES (question_seq.NEXT_VAL, ?, ?, ?, ?)";
		Question createdQuestion = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, question.getType());
			statement.setString(2, question.getStatement());
			statement.setString(3, question.getAnswer());
			statement.setString(4, question.getImageURL());
			if (statement.executeUpdate() > 0) {
				createdQuestion = question;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return createdQuestion;
	}

	@Override
	public Question update(int qnumber, Question question) {
		// TODO Auto-generated method stub
		String sql = "UPADET QUESTION SET TYPE = ?, STATEMENT = ?, ANSWER = ?, IMAGEURL = ? WHERE NO = ?";
		Question updatedQuestion = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, question.getType());
			statement.setString(2, question.getStatement());
			statement.setString(3, question.getAnswer());
			statement.setString(4, question.getImageURL());
			statement.setInt(5, qnumber);
			if (statement.executeUpdate() > 0) {
				updatedQuestion = question;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return updatedQuestion;
	}

	@Override
	public Question delete(int qnumber) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM QUESTION WHERE NO = ?";
		Question deletedQuestion = getQuestionFor(qnumber);
		if (deletedQuestion != null) {
			try (Connection connection = DatabaseConnection.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, qnumber);
				if (statement.executeUpdate() <= 0) {
					deletedQuestion = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return deletedQuestion;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM QUESTION";
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
