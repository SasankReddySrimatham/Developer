package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.UserNotFoundException;
import com.dto.Userdto;
import com.model.User;
import com.repository.IUserRepository;
@Service
public class IUserService 
{
	 @Autowired 
	 IUserRepository repo;
	 public Userdto login(User users) throws UserNotFoundException {
			Optional<User> opt=repo.findByUsername(users.getUsername());
			System.out.print(opt);
			if(!opt.isPresent()) {
				throw new UserNotFoundException("Invalid Credentials");
				}
			User dbLogin=opt.get();
			if(users.getUsername().equalsIgnoreCase(dbLogin.getUsername()) &&
			users.getPassword().equalsIgnoreCase(dbLogin.getPassword())&&
			users.getRole().equalsIgnoreCase(dbLogin.getRole())){
				dbLogin.setIsloggedin(true);
			
			
			repo.save(dbLogin);
			Userdto dto=new Userdto();
			dto.setUsername(users.getUsername());
			dto.setRole(users.getRole());
			dto.setLoggedIn(true);
			
			return dto;
		}
		else 
		{
			throw new UserNotFoundException("Invalid Credentials");
		
		}
	}
	 public Userdto logout(String username) throws UserNotFoundException {
			Optional<User> opt=repo.findByUsername(username);
			if(!opt.isPresent()) {
				throw new UserNotFoundException("Invalid Credentials");
				
			}
			User login=opt.get();
			
			login.setIsloggedin(false);
			repo.save(login);
			Userdto loginDto=new Userdto();
			loginDto.setLoggedIn(false);
			return loginDto;
			
		}
}
