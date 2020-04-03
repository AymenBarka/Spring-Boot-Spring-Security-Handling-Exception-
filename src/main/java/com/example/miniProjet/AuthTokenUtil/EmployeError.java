package com.example.miniProjet.AuthTokenUtil;

import org.springframework.http.HttpStatus;

public class EmployeError {
	  private HttpStatus status;
	   private String message;

	   private EmployeError() {
	   }

	   public EmployeError(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   public EmployeError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	   }

	   public EmployeError(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	   }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	   
}
