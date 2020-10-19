package com.Twitter.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Twitter.auth.model.Tweets;
import com.Twitter.auth.repository.TweetRepository;

@Service 

public class TweetServiceImpl implements TweetService{
			
	@Autowired
	private TweetRepository tweetRepository;
	
	 @Override
	    public void save(Tweets tweets) {
	tweetRepository.save(tweets);
	 }
	 
	@Override
	public List<Tweets> findByUsername(String username) {
		return tweetRepository.findByUsername(username);
	}
	

}
