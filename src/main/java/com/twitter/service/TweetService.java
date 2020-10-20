package com.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.model.Tweet;
import com.twitter.repository.TweetRepository;

@Service 
public class TweetService{
			
	@Autowired
	private TweetRepository tweetRepository;
	
	    public void save(Tweet tweets) {
	tweetRepository.save(tweets);
	 }
	 
	public List<Tweet> findByUserId(String username) {
		return tweetRepository.findByUserId(username);
	}
}
