package com.example.PracticeExceptions.Response;

import org.springframework.http.HttpStatus;

public class Response {
	
	private String response;
	
	private HttpStatus status;

	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Response(String response, HttpStatus status) {
		super();
		this.response = response;
		this.status = status;
	}

	
}
