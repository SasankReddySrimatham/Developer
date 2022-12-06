package com.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Developer;
import com.model.Feeds;
import com.model.Response;
@Repository
public interface IResponseRepository extends JpaRepository<Response,Integer>
{

	
	@Query("Select d from Response d ")
	List<Response> fetchAllResponse();
	@Query("Select d from Response d where d.feed.feedId=:feedid")
	List<Response> findByFeedId(int feedid);

}
