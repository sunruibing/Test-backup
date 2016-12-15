package com.servlet.cyclopedia;

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
import com.service.CyclopediaService;
@WebServlet(name="FindCyclopediaId",urlPatterns={"/FindCyclopediaId"})
public class FindCyclopediaId extends HttpServlet {

	/**
	 * 根据id获取文章
	 */
	private static final long serialVersionUID = 9033341806048488217L;
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		CyclopediaService cyclopediaService = new CyclopediaService();
		
		try {
		List<Map<String,Object>> list =	cyclopediaService.findCyclopediaById(id);
			Gson gson = new Gson();
			String cyclopedia =	gson.toJson(list);
		 response.getWriter().print(cyclopedia);	
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(1);//获取失败
		}
	}
}
