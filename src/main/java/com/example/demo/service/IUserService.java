package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.service.ex.InsertException;
import com.example.demo.service.ex.UsernameDuplicateException;
import org.springframework.stereotype.Service;

/**
 * 处理用户数据的业务层接口
 */
//@Service
public interface IUserService {

	/**
	 * 用户注册
	 * @param user 用户数据
	 * @throws UsernameDuplicateException 用户名冲突异常，例如尝试注册已经被占用的用户名
	 * @throws InsertException 插入数据异常
	 */
	void reg(User user)
		throws UsernameDuplicateException, InsertException;
	
}




