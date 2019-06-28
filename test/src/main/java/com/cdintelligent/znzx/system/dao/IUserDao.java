package com.cdintelligent.znzx.system.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cdintelligent.znzx.common.utils.JsonUtils.Status;
import com.cdintelligent.znzx.system.domain.User;

@Repository
public interface IUserDao {

	User getUserInfo(Map<String, Object> map);

}
