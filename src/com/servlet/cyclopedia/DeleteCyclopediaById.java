package com.servlet.cyclopedia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CyclopediaService;
@WebServlet(name="DeleteCyclopediaById",urlPatterns={"/DeleteCyclopediaById"})
public class DeleteCyclopediaById extends HttpServlet {

	/**
	 * 管理后台根据文章id删除文章
	 */
	private static final long serialVersionUID = -7518696244673588167L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		CyclopediaService  cyclopediaService  = new CyclopediaService();
		
	    Integer id = Integer.parseInt(request.getParameter("id"));
	    
	    try {
	    	cyclopediaService.deleteCyclopediaById(id);
            
	    	response.getWriter().print(0);//删除成功
		} catch (Exception e) {
            response.getWriter().print(1);//删除失败
		}
	}
}
