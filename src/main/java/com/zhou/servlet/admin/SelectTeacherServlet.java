package com.zhou.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhou.pojo.Teacher;
import com.zhou.service.TeacherService;
import com.zhou.service.impl.TeacherServiceImpl;


@WebServlet("/SelectTeacherServlet")
public class SelectTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SelectTeacherServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		TeacherService teacherService = new TeacherServiceImpl();
		List<Teacher> list = teacherService.select();
		HttpSession session = request.getSession();
		session.setAttribute("teas", list);
		response.sendRedirect("/CourseSystem/ujs/admin/teas.jsp");
	}

}
