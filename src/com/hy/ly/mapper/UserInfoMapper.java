package com.hy.ly.mapper;

import java.util.List;

import com.hy.ly.po.UserInfo;
import com.hy.ly.po.UserInfoCustom;
import com.hy.ly.po.UserInfoQueryVo;

public interface UserInfoMapper {

	public UserInfo findUserInfoById(int userid) throws Exception;
	
	public void insertUserInfo(UserInfo userInfo) throws Exception;
	
	public void deleteUserInfo(int userid) throws Exception;
	
	public List<UserInfo> findUserByName(String username) throws Exception;
	
	public void updateUserInfo(UserInfo userInfo) throws Exception;
	
	public List<UserInfoCustom> findUserInfoList(UserInfoQueryVo userInfoQueryVo) throws Exception;

	public int findUserInfoCount(UserInfoQueryVo userInfoQueryVo) throws Exception;
	
	public UserInfo findUserInfoByResultMap(int userid) throws Exception;
}
