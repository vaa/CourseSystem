package com.zhou.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhou.pojo.Student;
import com.zhou.service.StudentService;
import com.zhou.service.impl.StudentServiceImpl;

@WebServlet("/ModifyPwdServlet")
public class ModifyPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyPwdServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String currentPwd = request.getParameter("current_pwd");
		String newPwd = request.getParameter("new_pwd");

		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("login_stu");
		String sno = student.getSno();
		StudentService studentService = new StudentServiceImpl();

		int row = 0;
		row = studentService.updatePwd(sno, newPwd);
		if (row > 0) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("fail.jsp");
		}
	}

}
