package com.example.demo.service.impl;

import java.util.Date;
import java.util.UUID;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.service.ex.InsertException;
import com.example.demo.service.ex.UsernameDuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;



/**
 * 处理用户数据的业务层实现类
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void reg(User user) throws UsernameDuplicateException, InsertException {
		// 根据参数user中的getUsername()获取尝试注册的用户名
		String username = user.getUsername();
		// 根据以上用户名查询用户数据
		User result = userMapper.findByUsername(username);
		// 判断查询结果是否不为null
		if (result != null) {
			// 是：用户名已经被占用，抛出UsernameDuplicateException
			throw new UsernameDuplicateException(
				"注册失败！尝试注册的用户名(" + username + ")已经被占用！");
		}
		
		// 用户名未被占用，允许注册
		// 向参数user中补全属性：盐值
		String salt = UUID.randomUUID().toString().toUpperCase();
		user.setSalt(salt);
		// 取出参数user中的原始密码
		String password = user.getPassword();
		// 将原始密码加密
		String md5Password = getMd5Password(password, salt);
		// 向参数user中补全属性：加密后的密码
		user.setPassword(md5Password);
		// 向参数user中补全属性：isDelete-0
		user.setIsDelete(0);
		// 向参数user中补全属性：4项日志
		Date now = new Date();
		user.setCreatedUser(username);
		user.setCreatedTime(now);
		user.setModifiedUser(username);
		user.setModifiedTime(now);
		// 执行注册
		Integer rows = userMapper.addnew(user);
		if (rows != 1) {
			throw new InsertException(
				"注册失败！插入用户数据时出现未知错误！请联系管理员！");
		}
	}

	/**
	 * 执行密码加密，获取加密后的密码
	 * @param password 原密码
	 * @param salt 盐值
	 * @return 加密后的密码
	 */
	private String getMd5Password(String password, String salt) {
		// 加密规则：使用“salt+password+salt”作为消息，执行3次摘要运算
		String str = salt + password + salt;
		for (int i = 0; i < 3; i++) {
			str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		}
		return str;
	}
	
}






