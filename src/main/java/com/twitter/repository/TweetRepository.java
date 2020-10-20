package com.twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.model.Tweet;


public interface TweetRepository extends JpaRepository<Tweet, Long>{
	List<Tweet> findByUserId(String username);

	//List<Tweets> findByUserId(String username);
}
