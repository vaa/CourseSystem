package com.zhou.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.zhou.mapper.CourseMapper;
import com.zhou.pojo.Course;
import com.zhou.service.CourseService;
import com.zhou.util.MybatisUtil;

public class CourseServiceImpl implements CourseService {

	
	public int insert(String name, String tno, String credit, String description) throws IOException {
		int row = 0;
		SqlSession sqlSession = MybatisUtil.getSession();
		CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
		row = mapper.insert(name, tno, credit, description);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	
	public int update(String name, String tno, String credit, String description) throws IOException {
		int row = 0;
		SqlSession sqlSession = MybatisUtil.getSession();
		CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
		row = mapper.update(name, tno, credit, description);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	
	public int delete(String name, String tno) throws IOException {
		int row = 0;
		SqlSession sqlSession = MybatisUtil.getSession();
		CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
		row = mapper.delete(name, tno);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	
	public List<Course> teacherSelect(String tno) throws IOException {
		SqlSession sqlSession = MybatisUtil.getSession();
		CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
		List<Course> list = mapper.teacherSelect(tno);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	
	public List<Map<String, String>> select() throws IOException {
		SqlSession sqlSession = MybatisUtil.getSession();
		CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
		List<Map<String, String>> list = mapper.select();
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	
	public List<Map<String, String>> search(String name) throws IOException {
		SqlSession sqlSession = MybatisUtil.getSession();
		CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
		List<Map<String, String>> list = mapper.search(name);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
}
