package com.example.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootNotUsingTomcatApplication {

	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println(arg);
		}
		SpringApplication.run(SpringBootNotUsingTomcatApplication.class, args);
	}
}
@RestController
@RequestMapping("/test")
class SimpleConroller {

	@Value("${server.name}")
	private String serverName;

	@Value("${spring.profiles.active}")
	private String activeProfile;

	@Value("${java.security.egd}")
	private String securityEgd;

	@GetMapping
	public String greeting() {
		return "Hello from server activeProfile => [" + activeProfile + "]serverName=["+serverName+"]";
	}

}