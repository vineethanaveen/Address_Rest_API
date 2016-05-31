package com.address.rest.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.address.rest.controller.AddressRestController;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * Handle all exceptions thrown by application
 */
@ControllerAdvice
public class AddressAppErrorHandler {

	private final MessageSource messageSource;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AddressAppErrorHandler.class);
	
	@Autowired
	private Environment env;

	@Autowired
	public AddressAppErrorHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public AddressAppError processValidationError(IllegalArgumentException exception,HttpServletRequest request) {
	
		LOGGER.error("Error Message: {}",exception.getLocalizedMessage());
		LOGGER.error("Error Code: {}",env.getProperty("address.validation.errocode"));
		LOGGER.error("URL: {}",request.getRequestURL().toString());
	   AddressAppError error = new AddressAppError();
	   error.setErrorCode(Integer.valueOf(env.getProperty("address.validation.errocode")));
	    error.setErrorMessage(exception.getLocalizedMessage());
	    error.setUrl(request.getRequestURL().toString());
	    return error;
		
	}


}
