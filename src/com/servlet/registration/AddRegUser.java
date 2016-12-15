package com.servlet.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Registration;
import com.service.RegistrationService;
@WebServlet(name="AddRegUser",urlPatterns={"/AddRegUser"})
public class AddRegUser extends HttpServlet {

	/**
	 * 医生端添加患者
	 */
	private static final long serialVersionUID = 2215112232612039778L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		request.setCharacterEncoding("utf-8");

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
        
		String name = request.getParameter("name");// 获取患者名字
		String gender = request.getParameter("gender");//获取性别
		String phone = request.getParameter("phone");// 获取患者手机号
		String orderCode = request.getParameter("order_code");// 获取订单号
		String reservationDate = request.getParameter("reservation_date");//就诊时间
		
		Registration registration = new Registration();
		      registration.setName(name);
		      registration.setGender(gender);
		      registration.setPhone(phone);
		      registration.setOrderCode(orderCode);
		      registration.setReservationDate(reservationDate);
		      
		 RegistrationService registrationService = new RegistrationService();
		 try {
			 registrationService.insertUser(registration);
			 response.getWriter().print(0);//插入成功
		} catch (Exception e) {
             response.getWriter().print(1);
		}
		 
	}
}
