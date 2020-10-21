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
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.common.controller.vo.ResultVo;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {
	@Pointcut("execution(public * com.github.*.controller.*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void deBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		log.info("--------------------------------------------------<Log In HTTP Request Start>--------------------------------------------------");
		log.info("URL : " + request.getRequestURL().toString());
		log.info("HTTP_METHOD : " + request.getMethod());
		log.info("IP : " + request.getRemoteAddr());
		log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
		log.info("--------------------------------------------------<Log In HTTP Request End>--------------------------------------------------");
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		log.info("方法的返回值 : " + ret);
	}

	// 后置异常通知
	@AfterThrowing("webLog()")
	public void throwss(JoinPoint jp) {
		log.info("方法异常时执行");
	}

	// 后置最终通知，不管是抛出异常或者正常退出都会执行
	@After("webLog()")
	public void after(JoinPoint jp) {
		log.info("方法最后执行");
	}

	// 环绕通知，相当于MethodInterceptor
	@Around("webLog()")
	public Object arround(ProceedingJoinPoint pjp) {
		log.info("方法环绕start");
		try {
			Object o = pjp.proceed();
			log.info("方法环绕proceed，结果是 :" + o);

			ResultVo resultVo = new ResultVo();
			resultVo.setCode(200);
			resultVo.setData(o);
			resultVo.setMessage("接口调用成功");
			return resultVo;
		} catch (Throwable e) {
			log.error(e.getLocalizedMessage());
			return null;
		}
	}
}
