package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * http://localhost/demo/login
	 *
	 * @return
	 */
	@RequestMapping("/login")
	public String showLogin() {
		return "login.html";
	}

	/**
	 * http://localhost/demo/admin
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
	 * http://localhost/demo/user
	 *
	 * @return
	 */
	@RequestMapping("/user")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_USER')")
	public String printUser() {
		return "拥有ROLE_USER角色";
	}
}
