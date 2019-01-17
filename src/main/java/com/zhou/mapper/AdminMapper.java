package com.zhou.mapper;


import org.apache.ibatis.annotations.Param;

import com.zhou.pojo.Admin;

public interface AdminMapper {
	Admin checkLogin(@Param("id") String id,@Param("pwd") String pwd);
	int updatepwd(@Param("id") String id,@Param("pwd")String pwd);
}
