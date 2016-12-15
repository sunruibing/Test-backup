package com.servlet.registration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.service.RegistrationService;
@WebServlet(name="FindReminUser",urlPatterns={"/FindReminUser"})
public class FindReminUser extends HttpServlet {

	/**
	 * 管理后台获取提醒用户
	 */
	private static final long serialVersionUID = 3881041482012091914L;
     
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response); 
   }
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
	   response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		RegistrationService registrationService = new RegistrationService();

		try {

			List<Map<String, Object>> uesrli = registrationService.quireUser();

			Gson gson = new Gson();
			String userinfo = gson.toJson(uesrli);

			response.getWriter().print(userinfo);

			System.out.println(userinfo);

		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(1);// 获取失败
		}
   }
}
