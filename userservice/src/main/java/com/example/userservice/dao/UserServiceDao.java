package com.example.userservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.userservice.beans.User;

@Repository
public class UserServiceDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<User> getAllUsers() {
		return jdbcTemplate.query("select * from users ", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet resultset, int i) throws SQLException {
				User user = new User();
				user.setFirstName(resultset.getString(1));
				user.setLastName(resultset.getString(2));
				user.setAddress(resultset.getString(3));
				user.setPhone(resultset.getString(4));
				return user;
			}

		});
	}

	public String saveUser(User user) {
		int result = jdbcTemplate.update(
				"INSERT INTO schema.tableName (FIRST_NAME, LAST_NAME, ADDRESS, PHONE) VALUES (?, ?, ?, ?)",
				user.getFirstName(), user.getLastName(), user.getAddress(), user.getPhone());
		return result == 1 ? "success" : "fail";
	}

}
