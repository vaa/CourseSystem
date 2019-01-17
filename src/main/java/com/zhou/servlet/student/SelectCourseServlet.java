package com.zhou.servlet.student;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhou.pojo.Student;
import com.zhou.service.ScService;
import com.zhou.service.impl.ScServiceImpl;

@WebServlet("/SelectCourseServlet")
public class SelectCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectCourseServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cno = request.getParameter("cno");
		Date date = new Date();
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("login_stu");
		String sno = student.getSno();
		ScService scService = new ScServiceImpl();
		int row = scService.insert(sno, cno, date);

		if (row > 0) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("fail.jsp");
		}
	}

}
