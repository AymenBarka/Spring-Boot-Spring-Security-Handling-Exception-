package com.example.miniProjet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniProjet.AuthTokenUtil.AuthToken;
import com.example.miniProjet.configSecurity.TokenProvider;
import com.example.miniProjet.entities.Employe;
import com.example.miniProjet.service.EmployeService;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	
	private TokenProvider jwtTokenUtil;
	@Autowired
	private EmployeService employeService;
    @PostMapping(value = "/login")

	 public ResponseEntity<?> register(@RequestBody Employe loginUser) throws AuthenticationException {

	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginUser.getUsername(),
	                        loginUser.getPassword()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        final String token = jwtTokenUtil.generateToken(authentication);
	        return ResponseEntity.ok(new AuthToken(token));
	    }

    @PostMapping(value="/register")
    public ResponseEntity<?> saveUser(@RequestBody Employe em){
    	employeService.addEmploye(em);
        return  new ResponseEntity<String>("add success", HttpStatus.ACCEPTED);
    }
}
