package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Slf4j
public class LoginController {

	@RequestMapping("/")
	public String showHome() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		log.info("当前登陆用户：" + name);
		return "index.html";
	}

	/**
	 * http://localhost/login
	 *
	 * @return
	 */
	@RequestMapping("/login")
	public String showLogin() {
		return "login.html";
	}

	/**
	 * http://localhost/admin
	 *
	 * @return
	 */
	@RequestMapping("/admin")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String printAdmin() {
		return "拥有ROLE_ADMIN角色";
	}

	/**
	 * http://localhost/user
	 *
	 * @return
	 */
	@RequestMapping("/user")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_USER')")
	public String printUser() {
		return "拥有ROLE_USER角色";
	}

	/**
	 * http://localhost/login/error
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping("/login/error")
	public void loginError(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		AuthenticationException exception = (AuthenticationException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		try {
			response.getWriter().write(exception.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * http://localhost/admin/r
	 *
	 * @return
	 */
	@RequestMapping("/admin/r")
	@ResponseBody
	@PreAuthorize("hasPermission('/admin','r')")
	public String printAdminR() {
		return "url:/admin，有r权限";
	}

	/**
	 * http://localhost/admin/c
	 *
	 * @return
	 */
	@RequestMapping("/admin/c")
	@ResponseBody
	@PreAuthorize("hasPermission('/admin','c')")
	public String printAdminC() {
		return "url:/admin，有c权限";
	}
}
