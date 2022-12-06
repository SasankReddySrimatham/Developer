package com.service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.repository.*;
import com.model.*;
@Service
public class IReposnseService 
{
	@Autowired
	IResponseRepository repo;
	public Response addResponse(Response resp)
	{
		repo.save(resp);
		return resp; 
	}	
	public Response editResponse(Response resp) throws Throwable
	{
		int id=resp.getRespId();
		Supplier s1= ()->new ResourceNotFoundException("Response Does not exist in the database");
		Response r1=repo.findById(id).orElseThrow(s1);
		r1.setAccuracy(resp.getAccuracy());
		r1.setDev(resp.getDev());
		r1.setFeed(resp.getFeed());
		r1.setRespDate(resp.getRespDate());
		r1.setAnswer(resp.getAnswer());
		repo.save(r1);
		return r1;
	}
	public Response deleteResponseById(int respid) throws Throwable	
	{
		Supplier s1= ()->new ResourceNotFoundException("Response Does not exist in the database");
		Response r2=repo.findById(respid).orElseThrow(s1);
		Response r1=repo.getById(respid);
		repo.deleteById(respid);
		return r1;
	}
	public List<Response> getDeveloper(int devId) 
	{ 
		Response r= repo.findById(devId).orElseThrow();
		List<Response> r1= new ArrayList<>(); 
		r1.add(r);
		return r1;  
	}
	public List<Response>getFeed(int feedId) 
	{  
		Response r= repo.findById(feedId).orElseThrow();
		List<Response> r1= new ArrayList<>(); 
		r1.add(r);  
		return r1;  
	}
	public List<Response> getresponse(int feedid) 
	  { 
		 List<Response> r1= new ArrayList<>();
		  r1=repo.findByFeedId(feedid);
		 
		  return r1;
	  
	  } 
	public Response responsebyid(int respid) 
	  { 
		 Response r1;
		  r1=repo.findById(respid).orElseThrow();
		 
		  return r1;
	  
	  } 
	  public List<Response> getAllresponse() 
	  { 
		  List<Response> lc1=repo.fetchAllResponse();
		  return lc1; 
	  } 	
}

