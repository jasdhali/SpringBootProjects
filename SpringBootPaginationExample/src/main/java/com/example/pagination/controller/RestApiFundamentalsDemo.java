package com.example.pagination.controller;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestApiFundamentalsDemo {
	
	@GetMapping("/greeting")
	public ResponseEntity<String> greeting(
			@RequestHeader(value = HttpHeaders.ACCEPT_LANGUAGE) String language,
			@RequestHeader(value = "my-number" , required = false) Integer myNumber
			){		
		return new ResponseEntity<String>("Hello User", HttpStatus.OK);
	}
	
	@GetMapping("/listHeades")
	public ResponseEntity<String> listHeades(
			@RequestHeader Map<String,String> allHeaders
			){
		allHeaders.forEach((k,v)-> {
			System.out.println("Header " + k + " and value is " + v );
		});
		
		return new ResponseEntity<String>("Hello User", HttpStatus.OK);
	}
}
