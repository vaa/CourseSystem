package com.zhou.util;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	
	static{
		String resource ="mybatis.xml";
		InputStream inputStream =null;
		try{
			inputStream=Resources.getResourceAsStream(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	public static SqlSession getSession(){
		return sqlSessionFactory.openSession();
	}
}
