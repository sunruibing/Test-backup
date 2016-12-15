package com.servlet.cyclopedia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DiseaseService;
@WebServlet(name="UpdateDisease",urlPatterns={"/UpdateDisease"})
public class UpdateDisease extends HttpServlet {

	/**
	 * 管理后台修改疾病名
	 */
	private static final long serialVersionUID = -3976723330760397217L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
        Integer id = Integer.parseInt(request.getParameter("id"));//疾病id
        String name = request.getParameter("title");
        String bio = request.getParameter("bio");
        String user_icon= request.getParameter("icon");
        String user_name = request.getParameter("userName");
        String user_put_question = request.getParameter("userPutQuestion");
        String doctor_icon = request.getParameter("cover");
        String doctor_name = request.getParameter("doctorName");
        String doctor_answer_question = request.getParameter("doctorAnswerQuestion");
        String symptom = request.getParameter("sympton");
        String cure = request.getParameter("pathogen");
        String prompt = request.getParameter("prompt");
        Integer section_id = Integer.parseInt(request.getParameter("section"));
        Integer doctor_id = Integer.parseInt(request.getParameter("doctor"));
        DiseaseService diseaseService = new DiseaseService();
        try {
        	diseaseService.updataDisease(id, name, bio, user_icon, user_name, user_put_question, doctor_icon, doctor_name, doctor_answer_question, symptom, cure, prompt, section_id, doctor_id);
            
        	response.getWriter().print(0);//成功
		} catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print(1);//失败
		}
		
	}
	
}
