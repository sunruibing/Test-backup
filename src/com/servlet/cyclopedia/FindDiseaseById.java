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
@WebServlet(name="FindDiseaseById",urlPatterns={"/FindDiseaseById"})
public class FindDiseaseById extends HttpServlet {

	/**
	 * 管理后台更新疾病列表
	 */
	private static final long serialVersionUID = -3976723330760397217L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		
		DiseaseService diseaseService = new DiseaseService();
		
		try {
		List<Map<String,Object>> list = diseaseService.findDiseaseById(id);
			Gson gson = new Gson();
			String disease = gson.toJson(list);
		response.getWriter().print(disease);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(1);//失败
		}
	}

}
