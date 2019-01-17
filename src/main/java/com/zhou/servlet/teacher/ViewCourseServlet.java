package com.zhou.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhou.pojo.Course;
import com.zhou.pojo.Teacher;
import com.zhou.service.CourseService;
import com.zhou.service.impl.CourseServiceImpl;

@WebServlet("/ViewCourseServlet")
public class ViewCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCourseServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CourseService courseService = new CourseServiceImpl();

		HttpSession session = request.getSession();
		Teacher tea = (Teacher) session.getAttribute("login_tea");
		String tno = tea.getTno();
		List<Course> list = courseService.teacherSelect(tno);
		session.setAttribute("course", list);
		response.sendRedirect("/CourseSystem/ujs/teacher/course.jsp");

	}

}
