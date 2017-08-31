package com.gnfo.global_exception;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionControllerAdvice {
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(IOException exception){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(SQLException exception){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(SQLException exception){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("globalerror");
		return andView;
	}
}