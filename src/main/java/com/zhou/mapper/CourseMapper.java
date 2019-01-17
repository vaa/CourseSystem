package com.zhou.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhou.pojo.Course;

public interface CourseMapper {
	int insert(@Param("name")String name,@Param("tno")String tno,@Param("credit")String credit,@Param("description")String description);
	int update(@Param("name")String name,@Param("tno")String tno,@Param("credit")String credit,@Param("description")String description);
	int delete(@Param("name")String name,@Param("tno")String tno);
	List<Course> teacherSelect(@Param("tno")String tno);
	List<Map<String, String>> select();
	//根据教师名和课程名模糊查询
	List<Map<String, String>> search(@Param("name")String name);
}
