package com.aptiwithabapi.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aptiwithabapi.models.Schedule;
import com.aptiwithabapi.utility.DatabaseConnection;

public class ScheduleDaoImpl implements ScheduleDao {

	@Override
	public List<Schedule> getAllSchedulesFor(long testId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM SCHEDULE WHERE TID = ?";
		List<Schedule> schedules = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, testId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.isBeforeFirst()) {
				schedules = new ArrayList<>();
				while (resultSet.next()) {
					Schedule schedule = new Schedule();
					schedule.setId(resultSet.getLong(1));
					schedule.setTestId(testId);
					schedule.setDate(resultSet.getDate(3));
					schedule.setConducted(resultSet.getString(4).charAt(0) == '1');
					
					schedules.add(schedule);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return schedules;
	}

	@Override
	public Schedule getScheduleFor(long testId, long scheduleId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM SCHEDULE WHERE TID = ? AND ID = ?";
		Schedule schedule = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, testId);
			statement.setLong(2, scheduleId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				schedule = new Schedule();
				schedule.setId(scheduleId);
				schedule.setTestId(testId);
				schedule.setDate(resultSet.getDate(3));
				schedule.setConducted(resultSet.getString(4).charAt(0) == '1');
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return schedule;
	}

	@Override
	public Schedule create(Schedule schedule) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO SCHEDULE VALUES (schedule.NEXT_VAL, ?, ?, '0')";
		Schedule createdSchedule = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, schedule.getTestId());
			statement.setDate(2, (Date) schedule.getDate());
			if (statement.executeUpdate() > 0) {
				createdSchedule = schedule;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return createdSchedule;
	}

	@Override
	public Schedule update(long scheduleId, Schedule schedule) {
		// TODO Auto-generated method stub
		String sql = "UPDATE SCHEDULE SET TID = ?, DATE = ?, ISCONDUCTED = ? WHERE ID = ?";
		Schedule updatedSchedule = null;
		if (getScheduleFor(scheduleId) != null) {
			try (Connection connection = DatabaseConnection.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, schedule.getTestId());
				statement.setDate(2, (Date) schedule.getDate());
				statement.setString(3, (schedule.getIsConducted()) ? String.valueOf('1') : String.valueOf('0'));
				statement.setLong(4, scheduleId);
				if (statement.executeUpdate() > 0) {
					updatedSchedule = schedule;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return updatedSchedule;
	}

	@Override
	public boolean deleteAllSchedulesFor(long testId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM SCHEDULE WHERE TID = ?";
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
	public Schedule deleteSchedule(long scheduleId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM SCHEDULE WHERE ID = ?";
		Schedule deletedSchedule = getScheduleFor(scheduleId);
		if (deletedSchedule != null) {
			try (Connection connection = DatabaseConnection.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, scheduleId);
				if (statement.executeUpdate() <= 0) {
					deletedSchedule = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return deletedSchedule;
	}
	
	private Schedule getScheduleFor(long scheduleId) {
		String sql = "SELECT * FROM SCHEDULE WHERE ID = ?";
		Schedule schedule = null;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, scheduleId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				schedule = new Schedule();
				schedule.setId(resultSet.getInt(1));
				schedule.setTestId(resultSet.getLong(2));
				schedule.setDate(resultSet.getDate(3));
				schedule.setConducted(resultSet.getString(4).charAt(0) == '1');
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return schedule;
	}

}
