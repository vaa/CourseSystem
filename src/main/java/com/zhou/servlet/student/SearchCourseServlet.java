package com.zhou.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhou.service.CourseService;
import com.zhou.service.impl.CourseServiceImpl;

@WebServlet("/SearchCourseServlet")
public class SearchCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchCourseServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		CourseService courseService = new CourseServiceImpl();
		String name = request.getParameter("name");
		List<Map<String,String>> list =courseService.search(name);
		HttpSession session=request.getSession();
		session.setAttribute("course", list);
		response.sendRedirect("/CourseSystem/ujs/student/viewAllCourse.jsp");
	}

}
