package com.servlet.lecture;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.LectureService;
@WebServlet(name="DeleteLectureById",urlPatterns={"/DeleteLectureById"})
public class DeleteLectureById extends HttpServlet {

	/**
	 * 管理后台删除视频
	 */
	private static final long serialVersionUID = -8047365539014927356L;
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	LectureService lectureService = new LectureService();
    	
    	Integer id = Integer.parseInt(request.getParameter("id"));
    	try {
    		lectureService.deleteLectureById(id);
            
    		response.getWriter().print(0);//删除成功
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(1);//删除失败
		}
    }	
}
