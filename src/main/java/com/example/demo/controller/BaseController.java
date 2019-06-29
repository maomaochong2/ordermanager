package com.example.demo.controller;

import com.example.demo.service.ex.InsertException;
import com.example.demo.service.ex.ServiceException;
import com.example.demo.service.ex.UsernameDuplicateException;
import com.example.demo.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 控制器类的基类
 */
public abstract class BaseController {
	
	/**
	 * 操作成功时的响应状态代号
	 */
	protected static final Integer SUCCESS = 2000;

	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult<Void> handleException(Throwable e) {
		JsonResult<Void> jr = new JsonResult<>(e);

		if (e instanceof UsernameDuplicateException) {
			jr.setState(4000);
		} else if (e instanceof InsertException) {
			jr.setState(5000);
		}

		return jr;
	}

}
