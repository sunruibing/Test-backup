package com.servlet.cyclopedia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.DiseaseLibrary;
import com.service.DiseaseService;
@WebServlet(name="AddDisease",urlPatterns={"/AddDisease"})
public class AddDisease extends HttpServlet {

	/**
	 * 管理后台添加疾病
	 */
	private static final long serialVersionUID = 4074447043375039329L;
   
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 请求编码

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		DiseaseLibrary diseaseLibrary = new DiseaseLibrary();
		
		diseaseLibrary.setName(request.getParameter("title"));
		diseaseLibrary.setSectionId(Integer.parseInt(request.getParameter("section")));
		System.out.println(Integer.parseInt(request.getParameter("section")));
		diseaseLibrary.setBio(request.getParameter("bio"));
		diseaseLibrary.setUserName(request.getParameter("userName"));
		diseaseLibrary.setUserIcon( request.getParameter("icon"));
		diseaseLibrary.setUserPutQuestion(request.getParameter("userPutQuestion"));
		diseaseLibrary.setDoctorIcon( request.getParameter("cover"));
		diseaseLibrary.setDoctorName(request.getParameter("doctorName"));
		diseaseLibrary.setDoctorAnswerQuestion(request.getParameter("doctorAnswerQuestion"));		
		diseaseLibrary.setSymptom(request.getParameter("sympton"));
		diseaseLibrary.setCure(request.getParameter("pathogen"));
		diseaseLibrary.setPrompt(request.getParameter("prompt"));
		diseaseLibrary.setDoctorId(Integer.parseInt(request.getParameter("doctor")));
		
		DiseaseService diseaseService = new DiseaseService();

		try {
			diseaseService.insertdisease(diseaseLibrary);

			response.getWriter().print(0);// 添加成功

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(1);// 添加失败
		}

	}
}
