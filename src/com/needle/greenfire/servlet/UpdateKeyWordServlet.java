package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.KeyWord;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateKeyWordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Model model = new Model();
		KeyWord keyWord = new KeyWord();
		int kid = Integer.parseInt(request.getParameter("kid"));
		String keyname = request.getParameter("kname");
		String parameter = request.getParameter("kpar");
		String note = request.getParameter("knote");
		if ((!Utils.isNull(keyname))
				&& (!Utils.isNull(request.getParameter("kid")))) {
			keyWord.setId(kid);
			keyWord.setKeyname(keyname);
			keyWord.setParameter(parameter);
			keyWord.setNote(note);
			if (model.updateKeyWord(keyWord))
				request.getRequestDispatcher("KeyManager").forward(request,
						response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
