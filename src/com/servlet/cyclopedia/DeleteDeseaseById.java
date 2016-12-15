package com.servlet.cyclopedia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DiseaseService;
@WebServlet(name="DeleteDeseaseById",urlPatterns={"/DeleteDeseaseById"})
public class DeleteDeseaseById extends HttpServlet {

	/**
	 * 管理后台删除疾病
	 */
	private static final long serialVersionUID = 6005753648559791248L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		DiseaseService diseaseService = new DiseaseService();
		try {
			diseaseService.deleteDieaseById(id);
			response.getWriter().print(0);//成功
		} catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print(1);//失败
		}
	}
	
}
