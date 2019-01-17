package com.zhou.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhou.service.ScService;
import com.zhou.service.impl.ScServiceImpl;

@WebServlet("/ModifyScoreServlet")
public class ModifyScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyScoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cno = request.getParameter("cno");
		String sno = request.getParameter("sno");
		String grade = request.getParameter("grade");
		ScService scService = new ScServiceImpl();
		int row = 0;
		row = scService.update(sno, cno, grade);
		if (row > 0) {
			response.sendRedirect("ViewStudentServlet");
		} else {
			response.sendRedirect("fail.jsp");
		}
	}

}
