package com.Twitter.auth.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;


@Entity
@Table(name = "tweets")
public class Tweets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String tweet;
    private String tweettime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	 public String getTweettime() { 
		 return tweettime; 
		 }
	public void setTweettime(String tweettime) {
		LocalDateTime c_time= LocalDateTime.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
	    this.tweettime = "Siva";//c_time.format(formatter);
	}

}
   
   

