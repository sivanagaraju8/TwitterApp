package com.Twitter.auth.validator;

import com.Twitter.auth.model.Tweets;
import com.Twitter.auth.model.User;
import com.Twitter.auth.service.TweetService;
import com.Twitter.auth.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TweetValidator implements Validator {
    @Autowired
    private UserService userService;
   

    @Override
    public boolean supports(Class<?> aClass) {
        return Tweets.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Tweets tweet = (Tweets) o;
        

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (tweet.getUsername().length() < 6 || tweet.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(tweet.getUsername()) == null) {
            errors.rejectValue("username", "Same.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tweet", "NotEmpty");
       
    }
}
