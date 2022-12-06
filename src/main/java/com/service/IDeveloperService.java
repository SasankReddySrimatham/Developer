package com.service;
  
  import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;

import com.advices.UnknownDeveloperException;
import com.model.Developer;
import com.repository.IDeveloperRepository;
  
  @Service 
  public class IDeveloperService {
  
  @Autowired 
  IDeveloperRepository repo; 
  public Developer addDeveloper(Developer dev) throws Throwable 
  { 
	  Developer s=repo.save(dev);
	  return s;
  } 
  
  public Developer updateDeveloper(Developer dev) throws Throwable
  { 
	  int id=dev.getDevId(); 
	  Supplier s1= ()->new UnknownDeveloperException("Developer Does not exist in the database");
	  Developer d=repo.findById(id).orElseThrow(s1);
	  d.setName(dev.getName());
	  d.setEmail(dev.getEmail());
	  d.setSkillLevel(dev.getSkillLevel());
	  d.setMemberSince(dev.getMemberSince());
	  d.setReputation(dev.getReputation());
	  d.setIsblocked(dev.isIsblocked());
	  d.setIsverified(dev.isIsverified());	 
	 Developer s= repo.save(d); 
	  return s; 
  } 
  public String deleteDeveloper(int id) 
	 {
		 Developer dev1=repo.findById(id).get();	
		 Developer dev = dev1;
		 repo.delete(dev);
		 return "deleted";
	 }
  public Developer getDeveloper(int devId) 
  { 
	  Developer c=repo.findById(devId).orElseThrow(); 
	  return c;
  
  } 
  public List<Developer> getAllDevelopers() 
  { 
	  List<Developer> lc1=repo.fetchAllDevelopers();
	  return lc1; 
  } 
}
 