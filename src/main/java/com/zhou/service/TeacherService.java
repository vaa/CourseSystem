package com.zhou.service;

import java.io.IOException;
import java.util.List;

import com.zhou.pojo.Student;
import com.zhou.pojo.Teacher;

public interface TeacherService {
	int insert(String tno,String name,String pwd) throws IOException;
	int update(String tno,String name,String pwd) throws IOException;
	int delete(String tno) throws IOException;
	int updatePwd(String tno,String pwd) throws IOException;
	List<Teacher> select() throws IOException;
	Teacher checkLogin(String tno,String pwd) throws IOException;
}
