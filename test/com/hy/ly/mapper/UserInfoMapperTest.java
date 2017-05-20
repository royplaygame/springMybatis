package com.hy.ly.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.po.UserInfo;

public class UserInfoMapperTest {

	private ApplicationContext applicationContext;

	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testFindUserInfoById() throws Exception {
		UserInfoMapper userInfoMapper=(UserInfoMapper) applicationContext.getBean("userMapper");
		UserInfo userInfo=userInfoMapper.findUserInfoById(1006);
		System.out.println(userInfo);
	}

	@Test
	public void testFindUserInfoByIdAutoScan() throws Exception {
		UserInfoMapper userInfoMapper=(UserInfoMapper) applicationContext.getBean("userInfoMapper");
		UserInfo userInfo=userInfoMapper.findUserInfoById(1006);
		System.out.println(userInfo);
	}

}
