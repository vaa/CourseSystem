package com.zhou.service.impl;
import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.zhou.mapper.AdminMapper;
import com.zhou.pojo.Admin;
import com.zhou.service.AdminService;
import com.zhou.util.MybatisUtil;


public class AdminServiceImpl implements AdminService{

	public Admin checkLogin(String id, String pwd) throws IOException {
		SqlSession sqlSession=MybatisUtil.getSession();
		AdminMapper mapper =sqlSession.getMapper(AdminMapper.class);
		Admin admin=mapper.checkLogin(id, pwd);
		sqlSession.commit();
		sqlSession.close();
		return admin;
	}

	public int updatepwd(String id, String pwd)  throws IOException{
		int row = 0;
		SqlSession sqlSession=MybatisUtil.getSession();
		AdminMapper mapper =sqlSession.getMapper(AdminMapper.class);
		row=mapper.updatepwd(id, pwd);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

}
