package com.needle.greenfire.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.needle.greenfire.Model.Model;

public class UserManager extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Model model = new Model();
		Map usersMap = model.findAllUsers();
		request.getSession().setAttribute("usersMap", usersMap);
		Collection usersListMap = usersMap.values();
		request.getSession().setAttribute("usersListMap", usersListMap);
		//���ͻ��˵�����ת��forward����getRequestDispatcher���������в��������ҳ���������
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
