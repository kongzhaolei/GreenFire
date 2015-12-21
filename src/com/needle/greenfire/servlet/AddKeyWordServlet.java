package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.KeyWord;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddKeyWordServlet extends HttpServlet {
	private static final long serialVersionUID = -3693072963457834858L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-");
		Model model = new Model();
		KeyWord keyWord = new KeyWord();
		String keyname = request.getParameter("kname");
		String parameter = request.getParameter("kpar");
		String note = request.getParameter("knote");
		if (!Utils.isNull(keyname)) {
			keyWord.setKeyname(keyname);
			keyWord.setParameter(parameter);
			keyWord.setNote(note);
			keyWord.setCreateTime(Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
			if (model.addKeyWord(keyWord))
				request.getRequestDispatcher("KeyManager").forward(request,
						response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
