package com.zhou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhou.pojo.Admin;
import com.zhou.pojo.Student;
import com.zhou.pojo.Teacher;
import com.zhou.service.AdminService;
import com.zhou.service.StudentService;
import com.zhou.service.TeacherService;
import com.zhou.service.impl.AdminServiceImpl;
import com.zhou.service.impl.StudentServiceImpl;
import com.zhou.service.impl.TeacherServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService adminService = (AdminService) new AdminServiceImpl();
	TeacherService teacherService = (TeacherService) new TeacherServiceImpl();
	StudentService studentService = (StudentService) new StudentServiceImpl();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String type = request.getParameter("user_leixing");

		if (type.equals("管理员")) {

			Admin admin = adminService.checkLogin(account, pwd);
			if (admin != null && !"".equals(admin)) {
				HttpSession session = request.getSession();
				session.setAttribute("login_admin", admin);
				response.sendRedirect("/CourseSystem/ujs/admin/main.html");
			} else {
				response.sendRedirect("fail.jsp");
			}
		} else if (type.equals("教师")) {
			Teacher teacher = teacherService.checkLogin(account, pwd);
			if (teacher != null && !"".equals(teacher)) {
				// 获取存放数据的区域
				HttpSession session = request.getSession();
				// 把从数据库查到的数据存放到session
				// 但是我们知道，按照账号和密码查询最多能查到一条数据
				session.setAttribute("login_tea", teacher);
				response.sendRedirect("/CourseSystem/ujs/teacher/main.html");
			} else {
				response.sendRedirect("fail.jsp");
			}
		} else if (type.equals("学生")) {
			Student student = studentService.checkLogin(account, pwd);
			if (student != null && !"".equals(student)) {
				// 获取存放数据的区域
				HttpSession session = request.getSession();
				// 把从数据库查到的数据存放到session
				// 但是我们知道，按照账号和密码查询最多能查到一条数据
				session.setAttribute("login_stu", student);
				response.sendRedirect("/CourseSystem/ujs/student/main.html");
			} else {
				response.sendRedirect("fail.jsp");
			}
		}
	}

}
