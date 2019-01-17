package com.zhou.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ScService {
	int insert(String sno,String cno,Date date) throws IOException;
	int update(String sno,String cno,String grade) throws IOException;
	int delete(String sno,String cno) throws IOException;
	List<Map<String,String>> select(String sno) throws IOException;
	List<Map<String,String>> teacherSelect(String tno) throws IOException;
}
