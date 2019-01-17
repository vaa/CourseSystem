package com.zhou.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zhou.mapper.TeacherMapper;
import com.zhou.pojo.Teacher;
import com.zhou.service.TeacherService;
import com.zhou.util.MybatisUtil;

public class TeacherServiceImpl implements TeacherService {

	public int insert(String tno, String name, String pwd) throws IOException {
		int row = 0;
		SqlSession sqlSession = MybatisUtil.getSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		row = mapper.insert(tno, name, pwd);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public int update(String tno, String name, String pwd) throws IOException {
		int row = 0;
		SqlSession sqlSession = MybatisUtil.getSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		row = mapper.update(tno, name, pwd);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public int delete(String tno) throws IOException {
		int row = 0;
		SqlSession sqlSession = MybatisUtil.getSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		row = mapper.delete(tno);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public int updatePwd(String tno, String pwd) throws IOException {
		int row = 0;
		SqlSession sqlSession = MybatisUtil.getSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		row = mapper.updatePwd(tno, pwd);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public List<Teacher> select() throws IOException {
		SqlSession sqlSession = MybatisUtil.getSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> list = mapper.select();
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	public Teacher checkLogin(String tno, String pwd) throws IOException {
		SqlSession sqlSession = MybatisUtil.getSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		Teacher Teacher = mapper.checkLogin(tno, pwd);
		sqlSession.commit();
		sqlSession.close();
		return Teacher;
	}

}
