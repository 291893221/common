package com.github.common.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.common.controller.vo.ResultVo;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@Order(100)
public class ResponseResultAspect {
	@Pointcut("execution(public * com.github.*.controller.*.*(..))")
	public void pointcut() {
	}
	
	// 环绕通知，相当于MethodInterceptor
	@Around("pointcut()")
	public Object arround(ProceedingJoinPoint pjp) {
		log.info("--------------------------------------------------<Log In ResultAspect Start>--------------------------------------------------");
		try {
			Object o = pjp.proceed();
			log.info("方法环绕proceed，结果是 :" + o);

			ResultVo resultVo = new ResultVo();
			resultVo.setCode(200);
			resultVo.setData(o);
			resultVo.setMessage("接口调用成功");
			log.info("--------------------------------------------------<Log In ResultAspect End>--------------------------------------------------");
			return resultVo;
		} catch (Throwable e) {
			log.error(e.getLocalizedMessage());
			return null;
		}
	}
}