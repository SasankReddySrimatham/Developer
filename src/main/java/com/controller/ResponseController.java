package com.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.model.*;
import com.service.*;
@RestController
@CrossOrigin
@RequestMapping(path="/api")
public class ResponseController 
{
		@Autowired
		IReposnseService responseservice;
		@PostMapping("/addResponse")	
		public ResponseEntity<Response>addResponse(@RequestBody Response r1)
		{
			Response feed1=responseservice.addResponse(r1);
			ResponseEntity re=new
			ResponseEntity<Response>(feed1,HttpStatus.OK);  
			return re;
		}
		@PutMapping("/editresponse")
		public ResponseEntity<Response>editResponse(@RequestBody Response r1) throws Throwable
		{
			Response r2=(Response) responseservice.editResponse(r1);
			ResponseEntity re=new ResponseEntity<Response>(r2,HttpStatus.OK);
			return re;		
		}
		@DeleteMapping("/Deleteresponse/{id}")
		public ResponseEntity<Response> deleteResponse(@PathVariable("id") int id) throws Throwable 
		{
			Response r2=(Response) responseservice.deleteResponseById(id);
			ResponseEntity re=new ResponseEntity<Response>(r2,HttpStatus.OK);
			return re;
		}
		@PostMapping("/GetFeed")
		public List<Response> getFeed(@RequestBody int feedid) 
		{
			List<Response> r2= responseservice.getFeed(feedid);
			ResponseEntity re=new ResponseEntity<Response>(HttpStatus.OK);
			return r2;	
		}
		@PostMapping("/GetDeveloper")
		public List<Response> getDeveloper(@RequestBody int devid) 
		{
			List<Response> r2= responseservice.getDeveloper(devid);
			ResponseEntity re=new ResponseEntity<Response>(HttpStatus.OK);
			return r2;	
		}
		@GetMapping(path="/getResponse/{id}")
		public List<Response> getresponse(@PathVariable("id") int id)
		{
			List<Response> d= responseservice.getresponse(id);
			return d;
		}
		@GetMapping(path="/ResponseById/{id}")
		public Response responseById(@PathVariable("id") int id)
		{
			Response d= responseservice.responsebyid(id);
			return d;
		}
		@GetMapping(path="/getAllResponse")
		public List<Response> getalldevelopers()
		{
			List<Response> d= responseservice.getAllresponse();
			return d;
		} 
		
}
