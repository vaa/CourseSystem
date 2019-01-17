package com.zhou.service.impl;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zhou.mapper.StudentMapper;
import com.zhou.pojo.Student;
import com.zhou.service.StudentService;
import com.zhou.util.MybatisUtil;


public class StudentServiceImpl implements StudentService{

	public int insert(String sno, String name, String pwd) throws IOException{
		int row=0;
		SqlSession sqlSession=MybatisUtil.getSession();
		StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
		row=mapper.insert(sno, name, pwd);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public int update(String sno, String name, String pwd) throws IOException{
		int row=0;
		SqlSession sqlSession=MybatisUtil.getSession();
		StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
		row=mapper.update(sno, name, pwd);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public int updatePwd(String sno, String pwd) throws IOException{
		int row=0;
		SqlSession sqlSession=MybatisUtil.getSession();
		StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
		row=mapper.updatePwd(sno, pwd);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public int delete(String sno) throws IOException{
		int row=0;
		SqlSession sqlSession=MybatisUtil.getSession();
		StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
		row=mapper.delete(sno);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public List<Student> select() throws IOException{
		SqlSession sqlSession=MybatisUtil.getSession();
		StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
		List<Student> list=mapper.select();
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	public Student checkLogin(String sno, String pwd) throws IOException{
		SqlSession sqlSession=MybatisUtil.getSession();
		StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
		Student student=mapper.checkLogin(sno, pwd);
		sqlSession.commit();
		sqlSession.close();
		return student;
	}



}
