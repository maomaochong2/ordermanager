package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.example.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 处理用户相关请求的控制器
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("reg")
	public JsonResult<Void> reg(User user) {
		userService.reg(user);
		return new JsonResult<>(SUCCESS);
	}

}









