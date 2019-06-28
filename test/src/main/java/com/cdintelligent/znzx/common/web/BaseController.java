package com.cdintelligent.znzx.common.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 控制器基类
 * @author michael
 *
 */
public class BaseController {

	  /**
     * APPLICATION_JSON_UTF8_VALUE
     */
    protected static final String APPLICATION_JSON_UTF8_VALUE = APPLICATION_JSON_VALUE + ";charset=UTF-8";

    /**
     * logger
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
}
