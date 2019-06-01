package com.cdintelligent.znzx.system.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdintelligent.znzx.common.utils.JsonUtils.Status;
import com.cdintelligent.znzx.system.dao.IUserDao;
import com.cdintelligent.znzx.system.domain.User;
import com.cdintelligent.znzx.system.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	
	/**
	 * logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserServiceImpl.class);
	
	
	
	@Override
	public User login(Map<String, Object> map) throws Exception {
		if (map!=null && map.size()>0) {
			 return userDao.getUserInfo(map);
		}
		return null;
	}

}
