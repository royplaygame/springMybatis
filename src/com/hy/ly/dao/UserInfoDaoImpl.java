package com.hy.ly.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hy.ly.po.UserInfo;

public class UserInfoDaoImpl extends SqlSessionDaoSupport implements UserInfoDao {

	@Override
	public UserInfo findUserById(int userid) throws Exception {
		//继承SqlSessionDaoSupport,通过this.getSqlSession()获得sqlSession
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("test.findUserInfoById", userid);
	}

	@Override
	public void addUserInfo(UserInfo userInfo) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("test.insertUserInfo", userInfo);
		sqlSession.commit();
	}

	@Override
	public void deleteUserInfo(int userid) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("test.deleteUserInfo",userid);
		sqlSession.commit();
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("test.updateUserInfo", userInfo);
		sqlSession.commit();
	}

	@Override
	public List<UserInfo> findUserInfoList() throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		List<UserInfo> list = sqlSession.selectList("test.findUserByName", "张");
		return list;
	}

	@Override
	public List<UserInfo> findUserByName(String username) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		List<UserInfo> list = sqlSession.selectList("test.findUserByName", "张");
		return list;
	}

}
