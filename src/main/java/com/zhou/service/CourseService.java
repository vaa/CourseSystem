package com.zhou.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.zhou.pojo.Course;

public interface CourseService {
	int insert(String name,String tno,String credit,String description) throws IOException;
	int update(String name,String tno,String credit,String description) throws IOException;
	int delete(String name,String tno) throws IOException;
	List<Course> teacherSelect(String tno) throws IOException;
	List<Map<String, String>> select() throws IOException;
	List<Map<String, String>> search(String name) throws IOException;
}
