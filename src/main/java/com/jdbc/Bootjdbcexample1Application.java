package com.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdbc.dao.UserDao;
import com.jdbc.model.User;

@SpringBootApplication
public class Bootjdbcexample1Application implements CommandLineRunner {
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(Bootjdbcexample1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/* creating table */
//		System.out.println("exuting ....." + this.userDao.createTable());
	
		/* inserting user */
//		User user = new User();
//		user.setId(102);
//		user.setName("Milan");
//		user.setAge(24);
//		user.setCity("Pune");
//		System.out.println("exuting ....." + this.userDao.insertUser(user));
		
		/* getting a user */
		
		System.out.println(this.userDao.getUser(101));
	}
}
