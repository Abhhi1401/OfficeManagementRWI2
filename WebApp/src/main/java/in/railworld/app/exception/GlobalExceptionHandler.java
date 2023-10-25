package in.railworld.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.railworld.app.controller.dto.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
             
	      @ExceptionHandler(EmployeeNotFoundException.class)
	      public ResponseEntity<Response<MyErrorDetails>> employeeNotFoundHandler(EmployeeNotFoundException e, HttpServletRequest req, HttpServletResponse res){
	    	  
	    	          Response<MyErrorDetails> res1 = new Response("failure", res.getHeader("Authentication"), false, new MyErrorDetails(LocalDateTime.now(), e.getLocalizedMessage(), req.getContextPath()));
	    	  
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res1);
	      
	      }
	      
	      
	      
	      @ExceptionHandler(IllegalArgumentException.class)
	      @ResponseBody
	      public ResponseEntity<MyErrorDetails> illegalArgumentExceptionHandler(IllegalArgumentException e, HttpServletRequest req, HttpServletResponse res) {
	          // Create an instance of your MyErrorDetails class
	          MyErrorDetails errorDetails = new MyErrorDetails(LocalDateTime.now(), "Invalid argument", req.getRequestURI());

	          // Set the HTTP status code for the response (400 Bad Request for IllegalArgumentException)
	          HttpStatus status = HttpStatus.BAD_REQUEST;

	          return new ResponseEntity<>(errorDetails, status);
	      }
}
