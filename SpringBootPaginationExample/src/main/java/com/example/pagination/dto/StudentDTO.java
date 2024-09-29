package com.example.pagination.dto;

import com.example.pagination.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

	private String firstName;
	private String lastName;
	private Character gender;

	public static Student to(StudentDTO studentDTO) {
		return Student.builder().firstName(studentDTO.getFirstName()).lastName(studentDTO.getLastName()).gender('M')
				.build();
	}
}