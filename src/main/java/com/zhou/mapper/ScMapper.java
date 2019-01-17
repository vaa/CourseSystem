package com.zhou.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ScMapper {
	int insert(@Param("sno")String sno,@Param("cno")String cno,@Param("date")Date date);
	int update(@Param("sno")String sno,@Param("cno")String cno,@Param("grade")String grade);
	int delete(@Param("sno")String sno,@Param("cno")String cno);
	List<Map<String, String>> select(@Param("sno")String sno);
	List<Map<String, String>> teacherSelect(@Param("tno")String tno);
}
