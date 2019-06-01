package com.cdintelligent.znzx.common.encrypt;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.huawei.util.security.AES128Encrypt;

public class EncryptJdbcConfig extends PropertyPlaceholderConfigurer {
	
	private static Logger log = Logger.getLogger(EncryptJdbcConfig.class);

	private final String JDBC_PASSWORD_KEY = "jdbc.password";

	@Override
	public void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		try {
			AES128Encrypt des = new AES128Encrypt();
			String password = props.getProperty(JDBC_PASSWORD_KEY);
			if (password != null) {
				props.setProperty(JDBC_PASSWORD_KEY, des.decrypt(password));
			}
			super.processProperties(beanFactory, props);
		} catch (Exception e) {
			log.error("【转换JDBC密码异常】", e);
		}
	}

}
