package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class LoginController {
	@Autowired
	private SessionRegistry sessionRegistry;

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

	/**
	 * http://localhost/login/invalid
	 *
	 * @return
	 */
	@RequestMapping("/login/invalid")
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public String invalid() {
		return "Session 已过期，请重新登录";
	}

	/**
	 * http://localhost/kick?username=test
	 * @param username
	 * @return
	 */
	@GetMapping("/kick")
	@ResponseBody
	public String removeUserSessionByUsername(@RequestParam String username) {
		int count = 0;

		// 获取session中所有的用户信息
		List<Object> users = sessionRegistry.getAllPrincipals();
		for (Object principal : users) {
			if (principal instanceof User) {
				String principalName = ((User) principal).getUsername();
				if (principalName.equals(username)) {
					// 参数二：是否包含过期的Session
					List<SessionInformation> sessionsInfo = sessionRegistry.getAllSessions(principal, false);
					if (null != sessionsInfo && sessionsInfo.size() > 0) {
						for (SessionInformation sessionInformation : sessionsInfo) {
							sessionInformation.expireNow();
							count++;
						}
					}
				}
			}
		}
		return "操作成功，清理session共" + count + "个";
	}
}
