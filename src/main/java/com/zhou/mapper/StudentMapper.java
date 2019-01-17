package com.zhou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhou.pojo.Student;

public interface StudentMapper {
	int insert(@Param("sno")String sno,@Param("name")String name,@Param("pwd")String pwd);
	int update(@Param("sno")String sno,@Param("name")String name,@Param("pwd")String pwd);
	int updatePwd(@Param("sno")String sno,@Param("pwd")String pwd);
	int delete(@Param("sno")String sno);
	List<Student> select();
	Student checkLogin(@Param("sno")String sno,@Param("pwd")String pwd);
}
