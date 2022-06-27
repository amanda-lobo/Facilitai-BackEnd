package com.example.facilitai.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.facilitai.model.User;
import com.example.facilitai.model.UserLogin;
import com.example.facilitai.repository.UserRepository;
import com.example.facilitai.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserService service;
	
	@GetMapping("/all")
	public ResponseEntity <List<User>> getAll(){
		
		return ResponseEntity.ok(repository.findAll());	
	}

	@GetMapping("/{idUser}")
	public ResponseEntity<User> getById(@PathVariable Long idUser) {
		return repository.findById(idUser)
			.map(res -> ResponseEntity.ok(res))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserLogin> login(@RequestBody Optional<UserLogin> userLogin) {
		return service.autenticarUsuario(userLogin)
			.map(res -> ResponseEntity.ok(res))
			.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<User> postUser(@Valid @RequestBody User user) {

		return service.cadastrarUsuario(user)
			.map(res -> ResponseEntity.status(HttpStatus.CREATED).body(res))
			.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<User> putUser(@Valid @RequestBody User user) {
					return service.atualizarUsuario(user)
							.map(res -> ResponseEntity.status(HttpStatus.OK).body(res))
							.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

}

