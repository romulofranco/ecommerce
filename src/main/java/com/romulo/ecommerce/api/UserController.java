package com.romulo.ecommerce.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@GetMapping
	public String getUsers() {
		return "{\"users\":[{\"name\":\"Romulo\", \"country\":\"Brazil\"}," +
		           "{\"name\":\"Pedro Pinto\",\"country\":\"Portugal\"}]}";
	}
}
