package com.mycompany.cosmosdb.nosql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootCosmosDbNoSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCosmosDbNoSqlApplication.class, args);
	}

}

@AllArgsConstructor
@RestController
class ConsmosSQLController {
	private final UserRepository repository;

	@GetMapping
	Flux<User> getUsers() {
		return repository.findAll();
	}
}

@AllArgsConstructor
@RestController
@RequestMapping("/family")
class FamilyConsmosSQLController {
	private final FamilyRepository familyRepository;

	@GetMapping("/allmembers")
	Flux<Family> getUsers() {
		return familyRepository.findAll();
	}
}

interface UserRepository extends ReactiveCosmosRepository<User, String> {

}

interface FamilyRepository extends ReactiveCosmosRepository<Family, String> {

}


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Container(containerName = "Items")
class User {
	@Id
	@GeneratedValue
	private String id;
	@NonNull
	private String firstName;
	@NonNull
	@PartitionKey
	private String lastName;
	@NonNull
	private String address;
}
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Container(containerName = "Items")
class Family {
	@Id
	@GeneratedValue
	private String id;
	@NonNull
	private String firstName;
	@NonNull
	@PartitionKey
	private String lastName;	
	private Address address;
    
    private String partitionKey;
    
    private String district;
    private Parent[] parents;
    private Child[] children;
    
    private boolean isRegistered;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Child {
    private String familyName;
    private String firstName;
    private String gender;
    private int grade;
    private Pet[] pets;    
}
@AllArgsConstructor
@NoArgsConstructor
@Data
class Pet {   
    private String givenName;
}
@AllArgsConstructor
@NoArgsConstructor
@Data
class Parent {   

    private String familyName;
    private String firstName;
}
@AllArgsConstructor
@NoArgsConstructor
@Data
class Address {
    private String state;
    private String county;
    private String city;
}