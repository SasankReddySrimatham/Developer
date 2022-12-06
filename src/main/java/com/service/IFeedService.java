package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.advices.UnknownDeveloperException;
import com.advices.UnknownFeedException;
import com.model.Developer;
import com.model.Feeds;
import com.model.Response;
import com.repository.IFeedRepository;

@Service
public class IFeedService 
{
		@Autowired
		IFeedRepository repo;
		
	public  Feeds addFeed(Feeds feed)
	{
		 repo.save(feed);
		 return feed;

	}
	public Feeds editFeed(Feeds feed) throws Throwable
	{
		int id=feed.getFeedId();
		Supplier s1= ()->new ResourceNotFoundException("Feed Does not exist in the database");
		Feeds r1=repo.findById(id).orElseThrow(s1);
		r1.setDev(feed.getDev());
		r1.setFeedDate(feed.getFeedDate());
		r1.setFeedTime(feed.getFeedTime());
		//System.out.println(feed.getQuery());
		r1.setKeyword(feed.getKeyword());
		r1.setQuery(feed.getQuery());
		r1.setTopic(feed.getTopic());
		r1.setRelevance(feed.getRelevance());
		r1.setResponses(feed.getResponses());
		r1.setTotalComments(feed.getTotalComments());
		repo.save(r1);
		return r1;
	}


	 public Feeds likeFeed(int feedId) throws UnknownFeedException 
	 { 
		 Feeds feed=repo.getById(feedId);
		 int c=feed.getRelevance();
		 feed.setRelevance(c+1);
		 repo.save(feed);
		 return feed; 
	 } 
	  
	public  Feeds getFeed(int feedId) throws UnknownFeedException 
	{
		Feeds feed=repo.getById(feedId);
		return feed ;	  
	}
	 
	 public Feeds removeFeed(int feedId) throws UnknownFeedException 
	 {
		 Feeds feed=repo.getById(feedId);
		 repo.deleteById(feedId);
		 return feed;
			
	 }
	 public Feeds deleteFeed(Feeds feed) 
	 {
		 int id=feed.getFeedId();
		 Feeds feed1=repo.getById(id);	
		 repo.delete(feed);
		 return feed1;
	 }

	 public List<Feeds>getFeedsByDeveloper(int devId)throws UnknownDeveloperException 
	 {
			 Feeds f=repo.findById(devId).orElseThrow();
			 List<Feeds>feed= new ArrayList<>() ;
			 feed.add(f);
			 return feed;
			 
	 }
	 public List<Feeds>getFeedsByKeyword(String keyword)
	 { 
		if(keyword!=null)
		{
			 return repo.findByKeyword(keyword); 
		} 
			 return repo.findAll(); 
	}
			 
	public List<Feeds>getFeedsByTopic(String topic) 
	{
		  List<Feeds>lfeed1=repo.findByTopic(topic); 
		  return lfeed1; 
	}
	 public List<Feeds> getAllfeed() 
	  { 
		  List<Feeds> lc1=repo.fetchAllFeeds();
		  return lc1; 
	  } 
	 public Feeds getFeeds(int feedId) 
	  { 
		  Feeds c=repo.findById(feedId).get();
		  return c;
	  
	  } 
	 public Feeds deleteFeedById(int feedid) throws Throwable	
		{
			Supplier s1= ()->new ResourceNotFoundException("Response Does not exist in the database");
			Feeds r2=repo.findById(feedid).orElseThrow(s1);
			Feeds r1=repo.getById(feedid);
			repo.deleteById(feedid);
			return r1;
		}
}


