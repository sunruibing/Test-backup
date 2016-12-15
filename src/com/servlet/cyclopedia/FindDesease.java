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
import com.service.DiseaseService;

@WebServlet(name="FindDesease",urlPatterns={"/FindDesease"})
public class FindDesease extends HttpServlet {

	/**
	 * 管理后台获取疾病列表
	 */
	private static final long serialVersionUID = 4206613863442576462L;

	@Override
	protected void doGet(HttpServletRequest reqquest, HttpServletResponse response) throws ServletException, IOException {
       doPost(reqquest, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
	
	   DiseaseService diseaseService = new DiseaseService();
	   try {
		   List<Map<String,Object>>  list =	diseaseService.quireDisease();
		   
		   
		   Gson gson = new Gson();
		   String desease = gson.toJson(list);
		   
		   response.getWriter().print(desease);
		   
	} catch (SQLException e) {
		  response.getWriter().print(1);
		e.printStackTrace();
	}
	}
}
