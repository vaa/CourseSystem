package com.zhou.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.zhou.mapper.ScMapper;
import com.zhou.service.ScService;
import com.zhou.util.MybatisUtil;

public class ScServiceImpl implements ScService {

	public int insert(String sno, String cno, Date date) throws IOException {
		int row = 0;
		SqlSession sqlSession = MybatisUtil.getSession();
		ScMapper mapper = sqlSession.getMapper(ScMapper.class);
		row = mapper.insert(sno, cno, date);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public int update(String sno, String cno, String grade) throws IOException {
		int row = 0;
		SqlSession sqlSession = MybatisUtil.getSession();
		ScMapper mapper = sqlSession.getMapper(ScMapper.class);
		row = mapper.update(sno, cno, grade);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public int delete(String sno, String cno) throws IOException {
		int row = 0;
		SqlSession sqlSession = MybatisUtil.getSession();
		ScMapper mapper = sqlSession.getMapper(ScMapper.class);
		row = mapper.delete(sno, cno);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}

	public List<Map<String, String>> select(String sno) throws IOException {
		SqlSession sqlSession = MybatisUtil.getSession();
		ScMapper mapper = sqlSession.getMapper(ScMapper.class);
		List<Map<String, String>> list = mapper.select(sno);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	
	public List<Map<String, String>> teacherSelect(String tno) throws IOException {
		SqlSession sqlSession = MybatisUtil.getSession();
		ScMapper mapper = sqlSession.getMapper(ScMapper.class);
		List<Map<String, String>> list = mapper.teacherSelect(tno);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

}
