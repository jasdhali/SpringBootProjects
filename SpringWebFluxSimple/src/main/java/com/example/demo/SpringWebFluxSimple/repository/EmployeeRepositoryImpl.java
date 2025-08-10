package com.example.demo.SpringWebFluxSimple.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.SpringWebFluxSimple.domain.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Override
	public Flux<Employee> findAllEmployees() {
		return null;
	}

	@Override
	public Mono<Employee> findEmployeeById(String id) {
		return null;
	}

}
