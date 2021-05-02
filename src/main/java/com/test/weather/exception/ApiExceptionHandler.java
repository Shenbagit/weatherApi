/**
 * 

Author Shenbagavalli
 */
package com.test.weather.exception;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.weather.model.response.ErrorInfo;
import com.test.weather.util.constatnts.ErrorConstants;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;


/**
 * @author Shenbagavalli
 *
 */

@Component
@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler {
	
	private static final  Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);
	@ExceptionHandler(ApiException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public Object handleException(ApiException e) {
		LOGGER.error(getStackTrace(e));
		return new ErrorInfo(e.getCode(), e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public Object handleException(Exception e) {
		LOGGER.error(getStackTrace(e));
		return new ErrorInfo(ErrorConstants.SERVICE_ERROR, ErrorConstants.SERVICE_ERROR_MESSAGE);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
		List<FieldError> fieldError = result.getFieldErrors();
		return processFieldError(fieldError);
	}

	
	/**
	 * @param fieldError
	 * @return
	 */
	private Object processFieldError(List<FieldError> fieldErrors) {
		ErrorInfo errorInfo = null;
		for(FieldError fieldError : fieldErrors) {
			errorInfo = new ErrorInfo(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return errorInfo;
	}

	private String getStackTrace(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
}
