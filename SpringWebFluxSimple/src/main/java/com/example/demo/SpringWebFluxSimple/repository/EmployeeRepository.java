package com.example.demo.SpringWebFluxSimple.repository;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.SpringWebFluxSimple.domain.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository {
	public Flux<Employee> findAllEmployees();
	
	public Mono<Employee> findEmployeeById(@PathVariable String id);
}
