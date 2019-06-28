package com.sefonsoft.ybgs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseTest {

	@Test
	public void test() {
		System.out.println("ok");
	}
}
