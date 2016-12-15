package com.servlet.lecture;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.KnowLedgeLecture;
import com.service.LectureService;
@WebServlet(name="AddLecture",urlPatterns={"/AddLecture"})
public class AddLecture extends HttpServlet {

	/**
	 * 管理后台添加文章
	 */
	private static final long serialVersionUID = 8380039029132667431L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String cover = request.getParameter("icon");
		String video = request.getParameter("video");
		
		KnowLedgeLecture KnowLedgeLecture = new KnowLedgeLecture();
			
		    KnowLedgeLecture.setTitle(title);
			
			KnowLedgeLecture.setCover(cover);
			
			KnowLedgeLecture.setVideo(video);
			
	    LectureService lectureService = new LectureService();
			
	   try {
		   lectureService.insertLecture(KnowLedgeLecture);
       		response.getWriter().print(0);//添加成功
	} catch (Exception e) {
		e.printStackTrace();
		response.getWriter().print(1);//添加失败
	}
	}
}
