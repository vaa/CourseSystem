package com.zhou.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhou.pojo.Teacher;
import com.zhou.service.ScService;
import com.zhou.service.impl.ScServiceImpl;

@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewStudentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ScService scService = new ScServiceImpl();
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("login_tea");
		String tno = teacher.getTno();
		List<Map<String, String>> list = scService.teacherSelect(tno);
		session.setAttribute("viewAllStu", list);
		response.sendRedirect("/CourseSystem/ujs/teacher/viewAllStudent.jsp");
	}

}
