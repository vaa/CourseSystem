package com.zhou.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zhou.service.CourseService;
import com.zhou.service.impl.CourseServiceImpl;

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCourseServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String tno = request.getParameter("tea_tno");
		String name = request.getParameter("tea_name");
		String credit = request.getParameter("tea_credit");
		String description = request.getParameter("tea_description");
		CourseService courseService = new CourseServiceImpl();
		int row = 0;
		row = courseService.insert(name, tno, credit, description);
		if (row > 0) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("fail.jsp");
		}
	}

}
