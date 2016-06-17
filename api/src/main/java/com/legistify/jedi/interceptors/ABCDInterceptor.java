package com.legistify.jedi.interceptors;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ABCDInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("Pre handle");
		Enumeration abcd = request.getHeaderNames();
		while (abcd.hasMoreElements()) {
			Object object = (Object) abcd.nextElement();
			System.out.println(object + " : " + request.getHeader((String)object));
		}
		System.out.println(request.getHeaderNames());

		return true;
	}

}
