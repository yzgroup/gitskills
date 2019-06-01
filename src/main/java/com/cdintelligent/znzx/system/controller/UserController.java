package com.cdintelligent.znzx.system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdintelligent.znzx.common.utils.JsonUtils.Status;
import com.cdintelligent.znzx.common.web.BaseController;
import com.cdintelligent.znzx.system.service.IUserService;


@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
    private IUserService userService;
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    @ResponseBody
    public Status querySchemeStatus(@RequestBody Map<String,Object> map)
    {
        try
        {
        	logger.info("---login----");
            return new Status(Status.TRUE, "Success", userService.login(map));
        }
        catch (Exception e)
        {
            logger.error("Query market subject extraction scheme type exception", e);
            
            return new Status(Status.FALSE, e.getMessage());
        }
    }
}
