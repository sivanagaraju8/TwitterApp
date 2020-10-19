package com.Twitter.auth.service;

import java.util.List;

import com.Twitter.auth.model.Tweets;

public interface TweetService {
	    void save(Tweets tweets);

	    List <Tweets> findByUsername(String username);

}
