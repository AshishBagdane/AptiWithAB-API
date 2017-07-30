package com.aptiwithabapi.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aptiwithabapi.models.Option;
import com.aptiwithabapi.utility.DatabaseConnection;

public class OptionsDaoImpl implements OptionsDao {

	@Override
	public List<Option> getAllOptionsFor(int qnumber) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM OPTIONS WHERE NO = ?";
		List<Option> options = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, qnumber);
			ResultSet resultSet = statement.executeQuery();
			options = new ArrayList<>();
			while (resultSet.next()) {
				Option option = new Option();
				option.setQuestionNo(qnumber);
				option.setOptionNo(resultSet.getByte(2));
				option.setOption(resultSet.getString(3));
				
				options.add(option);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return options;
	}

	@Override
	public Option getOptionFor(int qnumber, int optnumber) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM OPTIONS WHERE NO = ? AND OPTNO = ?";
		Option option = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, qnumber);
			statement.setInt(2, optnumber);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				option = new Option();
				option.setQuestionNo(qnumber);
				option.setOptionNo(resultSet.getByte(2));
				option.setOption(resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return option;
	}

	@Override
	public List<Option> create(List<Option> options) {
		// TODO Auto-generated method stub
		List<Option> createdOptions = new ArrayList<>();
		for (Option option : options) {
			createdOptions.add(create(option));
		}
		return createdOptions;
	}
	
	private Option create(Option option) {
		String sql = "INSERT INTO OPTIONS VALUES (? , ?, ?)";
		Option createdOption = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, option.getQuestionNo());
			statement.setInt(2, option.getOptionNo());
			statement.setString(3, option.getOption());
			if (statement.executeUpdate() > 0) {
				createdOption = option;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return createdOption;
	}

	@Override
	public Option update(int qnumber, int optnumber, Option option) {
		// TODO Auto-generated method stub
		String sql = "UPDATE OPTIONS SET OPTION = ? WHERE NO = ? AND OPTNO = ?";
		Option updatedOption = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(2, option.getQuestionNo());
			statement.setInt(3, option.getOptionNo());
			statement.setString(1, option.getOption());
			if (statement.executeUpdate() > 0) {
				updatedOption = option;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return updatedOption;
	}

	@Override
	public boolean delete(int qnumber) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM OPTIONS WHERE NO = ?";
		boolean status = false;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, qnumber);
			status = (statement.executeUpdate() > 0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Option delete(int qnumber, int optnumber) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM OPTIONS WHERE NO = ? AND OPTNO = ?";
		Option deletedOption = getOptionFor(qnumber, optnumber);
		if (deletedOption != null) {
			try (Connection connection = DatabaseConnection.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, qnumber);
				statement.setInt(2, optnumber);
				if (statement.executeUpdate() <= 0) {
					deletedOption = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return deletedOption;
	}

}
