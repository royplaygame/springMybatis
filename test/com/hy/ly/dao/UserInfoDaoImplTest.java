package com.hy.ly.dao;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.po.UserInfo;

public class UserInfoDaoImplTest {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void before(){
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() throws Exception {
		UserInfoDao userInfoDao=(UserInfoDao) applicationContext.getBean("userInfoDao");
		
		//调用userInfoDao的方法
		UserInfo userInfo=userInfoDao.findUserById(1006);
		System.out.println(userInfo);
	}

}
