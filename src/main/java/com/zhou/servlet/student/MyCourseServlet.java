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

import com.zhou.pojo.Student;
import com.zhou.service.ScService;
import com.zhou.service.impl.ScServiceImpl;

@WebServlet("/MyCourseServlet")
public class MyCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyCourseServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("login_stu");
		String sno = student.getSno();
		ScService scService = new ScServiceImpl();

		List<Map<String, String>> list = scService.select(sno);
		session.setAttribute("course", list);

		response.sendRedirect("/CourseSystem/ujs/student/myCourse.jsp");
	}

}
