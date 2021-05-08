package com.example.PracticeExceptions.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.PracticeExceptions.Model.User;
import com.example.PracticeExceptions.Response.Response;
import com.example.PracticeExceptions.Service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService; 
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
	    ResponseEntity<?> response =null;
	    response = new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
		return response;
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	  public ResponseEntity<?> handleNoSuchElementFoundException(ConstraintViolationException exception) {
		Response response2 = new Response(exception.getConstraintViolations().stream().map(p->p.getMessageTemplate()).collect(Collectors.toList()).toString(),HttpStatus.BAD_GATEWAY); 
		ResponseEntity<?> response = new ResponseEntity<>(response2,HttpStatus.BAD_GATEWAY);
	    return response;
	  }
	
	
//	@PostMapping("/saveUser")
//	public ResponseEntity<?> saveUser(@Valid @RequestBody User user,BindingResult bindingResult) {
//		
//	    ResponseEntity<?> response =null;
//     	StringBuilder builder = new StringBuilder();
//	    List<FieldError> errors = bindingResult.getFieldErrors();
//	    for (FieldError error : errors ) {
//	        builder.append(error.getField() + " : " + 
//	        				error.getDefaultMessage()+ " : " +
//	        				error.getCode()+ " : " +
//	        				error.hashCode());
//	     } 
//	    if(StringUtils.isEmpty(builder)) {
//	    	response = new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
//	    }else {
//	    	Response response2 = new Response(builder.toString(),HttpStatus.BAD_GATEWAY); 
//		    response = new ResponseEntity<>(response2,HttpStatus.BAD_GATEWAY);
//	    }
//		return response;
//	}
	
	
}
