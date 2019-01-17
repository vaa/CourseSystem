package com.zhou.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zhou.pojo.Student;
import com.zhou.util.MybatisUtil;

public class StudentMapperTest {

	@Test
	public void m1(){
		SqlSession sqlSession=MybatisUtil.getSession();
		StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
		Student stu=new Student();
		stu.setSno("123456");
		stu.setName("name");
		stu.setPwd("password");
		stu.setSex("��");
		
		mapper.insert("123","脏哦","pwd");
		sqlSession.commit();
		
		sqlSession.close();
	}
}
