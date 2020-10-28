package com.github.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.common.controller.vo.ResultVo;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@Order(2)
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

			ResultVo<Object> resultVo = new ResultVo<Object>(o);
			log.info("--------------------------------------------------<Log In ResultAspect End>--------------------------------------------------");
			return resultVo;
		} catch (Throwable e) {
			log.error(e.getLocalizedMessage(), e);
			return null;
		}
	}
}
