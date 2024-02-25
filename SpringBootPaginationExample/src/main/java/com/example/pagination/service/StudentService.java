package com.example.pagination.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.pagination.entity.Student;
import com.example.pagination.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
/*
 * This class is marked as a Service, which is typically used in the Spring
 * Framework.
 */
@AllArgsConstructor
public class StudentService {
	private final StudentRepository repository;

	public Page<Student> getAllStudents(Pageable pageable) {
		return repository.findAll(pageable);
	}
}