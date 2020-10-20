package com.twitter.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.twitter.model.Tweet;
import com.twitter.service.UserService;

@Component
public class TweetValidator implements Validator {
    @Autowired
    private UserService userService;
   
    @Override
    public boolean supports(Class<?> aClass) {
        return Tweet.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Tweet tweet = (Tweet) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "NotEmpty");
        if (tweet.getUserId().length() < 6 || tweet.getUserId().length() > 32) {
            errors.rejectValue("userId", "Size.userForm.username");
        }
        if (userService.findByUsername(tweet.getUserId()) == null) {
            errors.rejectValue("userId", "Same.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tweet", "NotEmpty");
       
    }
}
