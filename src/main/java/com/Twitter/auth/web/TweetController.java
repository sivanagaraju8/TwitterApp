package com.Twitter.auth.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.Twitter.auth.model.Tweets;
import com.Twitter.auth.service.TweetService;
@Controller
public class TweetController {
	  @Autowired
	    private TweetService tweetService;
	  
	  @GetMapping("sendtweet5")
	    public String home(Model model) {
	        return "sendtweet";
	    }
	    
	   @PostMapping ("sendtweet5")
	   @ResponseBody
	    public String home( @RequestParam (name="username") String username, @RequestParam(name="tweet") String tweet ) {// Tweets tweet ) {
	    	//@ModelAttribute("tweetForm") Tweets tweetForm//, BindingResult bindingResult) {
	        //userValidator.validate(tweetForm, bindingResult);

			/*
			 * if (bindingResult.hasErrors()) { return "welcome"; }
			 */
	    	System.out.println("went inner");
	    	System.out.println("Parameters are " + username+tweet);
	        //tweetService.save(tweet);
	        

	        return "welcome";
	    }
}
