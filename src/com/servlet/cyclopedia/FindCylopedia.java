package com.servlet.cyclopedia;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
/**
 * 管理后天添加文章
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.service.CyclopediaService;
@WebServlet(name="FindCylopedia",urlPatterns={"/FindCylopedia"})
public class FindCylopedia extends HttpServlet {

	private static final long serialVersionUID = 8794353156523046502L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		CyclopediaService  cyclopediaService = new CyclopediaService();
	try {
		List<Map<String,Object>> list = cyclopediaService.quireCyclopedia();
		
		Gson gson = new Gson();	
	   
		response.getWriter().print(gson.toJson(list));;
		
		
	} catch (SQLException e) {
		e.printStackTrace();
		response.getWriter().print(1);//获取失败
	}		
	}
}
