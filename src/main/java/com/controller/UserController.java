package com.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping; 
//import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.advices.UserNotFoundException;
import com.dto.Userdto;
//import com.model.Developer;
import com.model.User;
import com.service.IUserService; 
 @RestController
 @CrossOrigin
 @RequestMapping(path="/api") 
public class UserController 
{
	 @Autowired 
	 IUserService userservice;
	 @PostMapping("/login")
		public ResponseEntity<Userdto> login(@RequestBody User users) throws UserNotFoundException
		{
			Userdto dto=userservice.login(users);
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
	 @PatchMapping("/logout/{username}")
		public ResponseEntity<Userdto> logout(@PathVariable("username") String Email) throws UserNotFoundException{
			Userdto dto=userservice.logout(Email);
			return new ResponseEntity<>(dto,HttpStatus.OK);
			
		}
}
