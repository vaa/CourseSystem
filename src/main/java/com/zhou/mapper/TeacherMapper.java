package com.zhou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhou.pojo.Teacher;


public interface TeacherMapper {
	int insert(@Param("tno")String tno,@Param("name")String name,@Param("pwd")String pwd);
	int update(@Param("tno")String tno,@Param("name")String name,@Param("pwd")String pwd);
	int updatePwd(@Param("tno")String tno,@Param("pwd")String pwd);
	int delete(@Param("tno")String tno);
	List<Teacher> select();
	Teacher checkLogin(@Param("tno")String tno,@Param("pwd")String pwd);
}
