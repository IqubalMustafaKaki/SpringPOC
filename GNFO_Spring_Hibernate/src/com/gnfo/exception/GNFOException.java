package com.gnfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GNFOException extends RuntimeException{

	private static final long serialVersionUID = -66285936344709942L;
	private String exceptionMsg;
	   
	   public GNFOException(String exceptionMsg) {
	      this.exceptionMsg = exceptionMsg;
	   }
	   
	   public String getExceptionMsg(){
	      return "GNFO Exception Flow --->"+this.exceptionMsg;
	   }
	   
	   public void setExceptionMsg(String exceptionMsg) {
	      this.exceptionMsg = "GNFO Exception Flow --->"+exceptionMsg;
	   }
	}