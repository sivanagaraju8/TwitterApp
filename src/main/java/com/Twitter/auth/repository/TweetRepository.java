package com.Twitter.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Twitter.auth.model.Tweets;


public interface TweetRepository extends JpaRepository<Tweets, Long>{
	List<Tweets> findByUsername(String username);
}
