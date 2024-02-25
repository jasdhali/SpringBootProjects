package com.example.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pagination.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {}
/*
Please note that JpaRepository also inherits from 
'PagingAndSortingRepository,' so we could extend it as well.
*/