package com.github.common.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.common.annotation.NoRepeatSubmit;
import com.google.common.cache.Cache;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@Order(3)
public class NoRepeatSubmitAspect {

	@Autowired
	private Cache<String, Integer> cache;

	@Pointcut("execution(public * com.github.*.controller.*.*(..)) && @annotation(noRepeatSubmit)")
	public void pointcut(NoRepeatSubmit noRepeatSubmit) {
	}

	@Before("pointcut(noRepeatSubmit)")
	public void before(JoinPoint joinPoint, NoRepeatSubmit noRepeatSubmit) {
	}

	@Around("pointcut(noRepeatSubmit)")
	public Object arround(ProceedingJoinPoint pjp, NoRepeatSubmit noRepeatSubmit) {
		log.info("--------------------------------------------------<Log In NoRepeatSubmitAspect Start>--------------------------------------------------");

		try {
			log.info("============ NoRepeatSubmitAspect ==============");
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
			log.info("sessionId: " + sessionId);
			HttpServletRequest request = attributes.getRequest();
			String key = sessionId + "-" + request.getServletPath();
			log.info("key: " + key);
			log.info("servletPath: " + request.getServletPath());
			if (cache.getIfPresent(key) == null) {// 如果缓存中有这个url视为重复提交
				Object o = pjp.proceed();
				cache.put(key, 0);
				log.info("--------------------------------------------------<Log In NoRepeatSubmitAspect end>--------------------------------------------------");
				return o;
			} else {
				log.error("重复提交");
				return "重复提交";
			}
		} catch (Throwable e) {
//			e.printStackTrace();
			log.error("验证重复提交时出现未知异常!" + e.getMessage(), e);
			return "{\"code\":-889,\"message\":\"验证重复提交时出现未知异常!\"}";
		}
	}

	@After("pointcut(noRepeatSubmit)")
	public void after(JoinPoint joinPoint, NoRepeatSubmit noRepeatSubmit) {
	}

}
