package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

	@Autowired
	UserMapper mapper;
	
	@Test
	public void addnew() {
		User user = new User();
		user.setUsername("admin2");
		user.setPassword("1234");
		System.err.println(user);
		Integer rows = mapper.addnew(user);
		System.err.println("rows=" + rows);
		System.err.println(user);
	}
	
	@Test
	public void findByUsername() {
		String username = "root";
		User result = mapper.findByUsername(username);
		System.err.println(result);
	}
	
}






