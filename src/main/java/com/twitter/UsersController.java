package com.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.twitter.model.User;

import com.twitter.service.SecurityService;

import com.twitter.service.UserService;

import com.twitter.validator.UserValidator;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;
   @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;
    
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

}
