package com.example.Electronics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class MyGloablException {
	@ExceptionHandler(PriceNotFoundException.class)
	public ResponseEntity<Object> HandlePrice(PriceNotFoundException a) {
	return new ResponseEntity<Object> (" Please enter valid price",HttpStatus.BAD_REQUEST);
		}
	
	@ExceptionHandler(ModelNotFoundException.class)
	public ResponseEntity<Object> HandleModel(ModelNotFoundException a) {
		return new ResponseEntity<Object> ("Please enter valid model",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ColorNotFoundException.class)
	public ResponseEntity<Object> HandleColor(ColorNotFoundException a) {
		return new ResponseEntity<Object> ("Please enter valid Color",HttpStatus.BAD_REQUEST);
	}
}
