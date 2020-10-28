package com.github.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.common.controller.vo.ResultVo;
import com.github.common.exception.bo.ResultEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 通用异常
	 */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler
	public ResultVo exception(Exception e) {
		log.error("通用异常: {} ", e.getLocalizedMessage());
		return new ResultVo(e);
	}
	
	/**
	 * 自定义异常
	 */
	@ExceptionHandler(value = CustomException.class)
	public ResultVo processException(CustomException e) {
		log.error("自定义异常，调用方法: {} -> 异常信息: {}", e.getMethod(), e.getLocalizedMessage());
		return new ResultVo(e);
	}

}