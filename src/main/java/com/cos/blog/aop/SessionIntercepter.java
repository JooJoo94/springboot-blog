package com.cos.blog.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 백종원 어댑터 패턴
// @Controller, @Configulation, @Service, @ Repository
public class SessionIntercepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null) {
			System.out.println("인증 안됐으니 나가");
			response.sendRedirect("/user/login");
			return false;		// 세션 없을 시 내보냄
		}
		System.out.println("인증 되었습니다");
		return true;
	}
}
