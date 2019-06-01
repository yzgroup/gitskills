package com.cdintelligent.znzx.system.service;

import java.util.Map;

import com.cdintelligent.znzx.system.domain.User;

/**
 * 用户服务接口类
 * @author michael
 *
 */
public interface IUserService {

	User login(Map<String,Object> map)  throws Exception;

	
}