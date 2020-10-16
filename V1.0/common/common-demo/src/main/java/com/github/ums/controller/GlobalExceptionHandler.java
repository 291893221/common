package com.github.ums.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.common.controller.vo.ResultVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

	/**
	 * 通用异常
	 */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler
	public ResultVo exception(Exception e) {
		log.error("位置: {} -> 错误信息: {}", e.getStackTrace(), e.getLocalizedMessage());
//		return ResultVoUtil.error(ResultEnum.UNKNOWN_EXCEPTION);
		return new ResultVo();
	}
}