package com.twitter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.twitter.model.Tweet;
import com.twitter.service.TweetService;
import com.twitter.validator.TweetValidator;
@Controller
public class TweetsController {
    @Autowired
    private TweetService tweetService;
    @Autowired
    private TweetValidator tweetValidator;
    
	@GetMapping({"/","/sendtweet"})
    public String sendtweet(Model model) {
        model.addAttribute("userForm", new Tweet());
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
             System.out.println(currentUserName);
             
             List<Tweet> allTweets = tweetService.findByUserId(currentUserName);//.getUserId());
          	 model.addAttribute("UserTweets",allTweets);
        } 
        return "sendtweet";
    }

    @PostMapping({"/","/sendtweet"})
    public String sendtweet(Model model, @ModelAttribute("userForm") Tweet userForm, BindingResult bindingResult) {
        tweetValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "sendtweet";
        }
        
        tweetService.save(userForm);
        model.addAttribute("success", "Tweeted Succesfully");
        List<Tweet> allTweets = tweetService.findByUserId(userForm.getUserId());//.getUserId());
     	 model.addAttribute("UserTweets",allTweets);
	 
		/*
		 * System.out.println(allStats.getTweet());
		 * System.out.println(allStats.getUsername());
		 * System.out.println(allStats.getId());
		 */

      //  securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "sendtweet";  ///redirect:/
    }
    /*
	 * @GetMapping({"/", "/sendtweet"}) public String welcome(Model model) { return
	 * "sendtweet"; }
	 */
}

