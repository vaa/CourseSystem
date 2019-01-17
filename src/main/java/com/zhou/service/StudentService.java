package com.zhou.service;

import java.io.IOException;
import java.util.List;

import com.zhou.pojo.Student;

public interface StudentService {
	int insert(String sno,String name,String pwd) throws IOException;
	int update(String sno,String name,String pwd) throws IOException;
	int updatePwd(String sno,String pwd) throws IOException;
	int delete(String sno) throws IOException;
	List<Student> select() throws IOException;
	Student checkLogin(String sno,String pwd) throws IOException;
}
