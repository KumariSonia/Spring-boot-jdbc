package com.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jdbc.model.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int createTable() {
		String query = "CREATE TABLE IF NOT EXISTS User (id int primary key , name varchar (200) , age int , city varchar(100))";
		int status = this.jdbcTemplate.update(query);
		return status;
	}

	public int insertUser(User user) {
		// Inserting User
		int status = 0;
		String query = "INSERT INTO User (id, name, age, city) VALUES (?, ?, ?,?)";
		status = this.jdbcTemplate.update(query, user.getId(), user.getName(), user.getAge(), user.getCity());

		return status;
	}

	public int updateUser(User user) {
		// Updating User
		int status = 0;
		String query = "update User set name=?, age=? city=? where id=?";
		status = this.jdbcTemplate.update(query, user.getName(), user.getAge(), user.getCity(), user.getId());

		return status;
	}

	public int deleteUser(int userId) {
		// deleting User

		int status = 0;
		String query = "delete from User where id=?";
		status = this.jdbcTemplate.update(query, userId);
		return status;
	}

	public User getUser(int userId) {

		// Single select query
		User user = null;

		String query = "select * from User where id=?";

		RowMapper<User> rowMapper = new RowMapperImpl();
		user = this.jdbcTemplate.queryForObject(query, rowMapper, userId);

		return user;
	}

//	public List<User> getAllUser() {
//		// multiple select
//
//		List<User> userList = null;
//
//		String query = "select * from user";
//
//		RowMapper<User> rowMapper = new RowMapperImpl();
//
//		userList = this.jdbcTemplate.query(query, rowMapper);
//
//		return userList;
//	}

}
