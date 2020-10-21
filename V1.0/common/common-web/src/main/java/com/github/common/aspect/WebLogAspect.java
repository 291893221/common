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
@Order(1000)
public class WebLogAspect {
	@Pointcut("execution(public * com.github.*.controller.*.*(..))")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void before(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		log.info("--------------------------------------------------<Log In WebLogAspect Start>--------------------------------------------------");
		log.info("URL : " + request.getRequestURL().toString());
		log.info("HTTP_METHOD : " + request.getMethod());
		log.info("IP : " + request.getRemoteAddr());
		log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
		log.info("--------------------------------------------------<Log In WebLogAspect End>--------------------------------------------------");
	}

	@AfterReturning(returning = "ret", pointcut = "pointcut()")
	public void afterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		log.info("方法的返回值 : " + ret);
	}

	// 后置异常通知
	@AfterThrowing("pointcut()")
	public void afterThrowing(JoinPoint jp) {
		log.info("方法异常时执行");
	}

	// 后置最终通知，不管是抛出异常或者正常退出都会执行
	@After("pointcut()")
	public void after(JoinPoint jp) {
		log.info("方法最后执行");
	}

	// 环绕通知，相当于MethodInterceptor
	@Around("pointcut()")
	public Object arround(ProceedingJoinPoint pjp) {
		log.info("方法环绕start");
		try {
			return pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pjp;
	}
}
