package com.zhou.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhou.pojo.Student;
import com.zhou.service.StudentService;
import com.zhou.service.impl.StudentServiceImpl;


@WebServlet("/SelectStudentServlet")
public class SelectStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectStudentServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.select();
		HttpSession session = request.getSession();
		session.setAttribute("stus", list);
		response.sendRedirect("/CourseSystem/ujs/admin/stus.jsp");
		
	}

}
