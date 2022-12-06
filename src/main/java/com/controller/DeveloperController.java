package com.controller;
  
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import com.model.Developer;
import com.model.Response;
import com.service.IDeveloperService; 
  
@RestController
@CrossOrigin
@RequestMapping(path="/api") 
public class DeveloperController 
{
	
	
	@Autowired 
	IDeveloperService developerservice;  
	@PostMapping("/addDeveloper") 
	public ResponseEntity<Developer> addDeveloper(@RequestBody Developer dev) throws Throwable 
	{
		Developer c1=developerservice.addDeveloper(dev);
		ResponseEntity re=new ResponseEntity<Developer>(c1,HttpStatus.OK);
		return re;
	}  
	@PutMapping(path="/updateDeveloper") 
	public ResponseEntity<Developer> updateDeveloper(@RequestBody Developer e) throws Throwable 
	{ 
		Developer e1=developerservice.updateDeveloper(e); 
		ResponseEntity re=new ResponseEntity<Developer>(e1,HttpStatus.OK);
		return re;
	}
	@DeleteMapping("/Deletedeveloper/{id}")
	public ResponseEntity<Response> deletedeveloper(@PathVariable("id") int devid) throws Throwable 
	{
		String r2=developerservice.deleteDeveloper(devid);
		ResponseEntity re=new ResponseEntity<Developer>(HttpStatus.OK);
		return re;	
	}
	@GetMapping(path="/getDeveloper/{id}")
	public Developer getdeveloper(@PathVariable("id") int id)
	{
		Developer d= developerservice.getDeveloper(id);
		return d;
	}
	@GetMapping(path="/getAllDevelopers")
	public List<Developer> getalldevelopers()
	{
		List<Developer> d= developerservice.getAllDevelopers();
		return d;
	}
	
}
 