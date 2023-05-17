package com.aljimez.BackCh.controller;
/*Imports*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.http.HttpHeaders;


import com.aljimez.BackCh.dao.ISuserDAO;
import com.aljimez.BackCh.dto.AuthResponseDTO;
import com.aljimez.BackCh.dto.Suser;
import com.aljimez.BackCh.security.JwtGenerator;
import com.aljimez.BackCh.service.SUserServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SUserController {
//Invocar service para interpretarlos
	@Autowired
	SUserServiceImpl userServiceImpl;
	
	private AuthenticationManager authenticationManager;

	private ISuserDAO iSuserDAO;

	private PasswordEncoder passwordEncoder;
	
	private JwtGenerator jwtGenerator;
//Constructor
	@Autowired
	public SUserController(ISuserDAO iUsuarioDAO, PasswordEncoder bCryptPasswordEncoder, JwtGenerator jwtGenerator,
			AuthenticationManager authenticationManager) {
		this.iSuserDAO = iUsuarioDAO;
		this.passwordEncoder = bCryptPasswordEncoder;
		this.jwtGenerator = jwtGenerator;
		this.authenticationManager = authenticationManager;
	}
	//Endpoints GET,POST,PUT
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponseDTO> login(@RequestBody Suser user) {
		UsernamePasswordAuthenticationToken test = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(test);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtGenerator.generateToken(authentication);
		AuthResponseDTO authResponseDTO = new AuthResponseDTO(token);
		return new ResponseEntity<>(authResponseDTO, HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<Suser> saveUsuario(@RequestBody Suser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		iSuserDAO.save(user);
		// return user;
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/")
	public String welcome() {
		return"Login & Register server Developede by Alejandro Jiménez Álvarez";
	}
	/** Get: List all users */
	@GetMapping("/susers")
	public List<Suser> listUsers() {
		return userServiceImpl.listUsers();
	}

	/** Get: Read info about an user */
	@GetMapping("/susers/{id}")
	public Suser getUserById(@PathVariable(name = "id") Long id) {
		return userServiceImpl.getUserById(id);
	}

	/** Update: an user */
	@PutMapping("/susers/{id}")
	public Suser updateUser(@PathVariable(name = "id") Long id, @RequestBody Suser user) {

		Suser user_selected = new Suser();

		user_selected = userServiceImpl.getUserById(id);
		user_selected.setUsername(user.getUsername());
		user_selected.setPassword(user.getPassword());
		
		return userServiceImpl.updateUser(user_selected);
	}

	/** Delete: an user */
	@DeleteMapping("/susers/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userServiceImpl.deleteUser(id);
	}

}

