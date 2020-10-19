package com.Twitter.auth.web;

import com.Twitter.auth.model.Tweets;
import com.Twitter.auth.model.User;
import com.Twitter.auth.service.SecurityService;
import com.Twitter.auth.service.TweetService;
import com.Twitter.auth.service.UserService;
import com.Twitter.auth.validator.TweetValidator;
import com.Twitter.auth.validator.UserValidator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
  
    
    @Autowired
    private SecurityService securityService;
    @Autowired
    private TweetService tweetService;
    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private TweetValidator tweetValidator;


	
	/*
	 * @GetMapping("/") public String home() { // model.addAttribute("userForm", new
	 * User());
	 * 
	 * return "login"; }
	 */

	
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/sendtweet";
    }
    
    @GetMapping({"/","/sendtweet"})
    public String sendtweet(Model model) {
        model.addAttribute("userForm", new Tweets());

        return "sendtweet";
    }

    @PostMapping({"/","/sendtweet"})
    public String sendtweet(Model model, @ModelAttribute("userForm") Tweets userForm, BindingResult bindingResult) {
        tweetValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "sendtweet";
        }
        
        tweetService.save(userForm);
        model.addAttribute("success", "Tweeted Succesfully");
        
	  List<Tweets> allTweets = tweetService.findByUsername(userForm.getUsername());
	  model.addAttribute("UserTweets",allTweets);
	//System.out.println(allStats);
	/*
	 * for(Tweets al:allStats) { System.out.println(al.getTweet());
	 * System.out.println(al.getUsername()); }
	 */
	 
		/*
		 * System.out.println(allStats.getTweet());
		 * System.out.println(allStats.getUsername());
		 * System.out.println(allStats.getId());
		 */

      //  securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "sendtweet";  ///redirect:/
    }
	/*
	 * @GetMapping("/welcome") public String sendtweet(Model model) {
	 * model.addAttribute("tweetForm", new Tweets());
	 * 
	 * return "welcome"; }
	 */

    
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";	
    }

	/*
	 * @GetMapping({"/", "/sendtweet"}) public String welcome(Model model) { return
	 * "sendtweet"; }
	 */
    
 

}
