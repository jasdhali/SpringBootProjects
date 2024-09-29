package com.example.pagination.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagination.dto.StudentDTO;
import com.example.pagination.entity.Student;
import com.example.pagination.repository.StudentRepository;
import com.example.pagination.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
/*
 * This class is marked as a RestController, indicating that it handles HTTP
 * requests
 */
@RequiredArgsConstructor
public class StudentController {
	private final StudentService service;
	private final StudentRepository repository;

	@GetMapping("/students")
	public Page<Student> getItems(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return service.getAllStudents(pageable);
	}

	@PostMapping("/students")
	public Student createStudent(@RequestBody Student dto) {
		return repository.save( dto );
	}

	@GetMapping("/greet")
	public String getGreeting() {
		return "hello user";
	}
}