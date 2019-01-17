package com.zhou.service;

import java.io.IOException;

import com.zhou.pojo.Admin;

public interface AdminService {
	
	Admin checkLogin(String id,String pwd) throws IOException;
	int updatepwd(String id,String pwd) throws IOException;
}
