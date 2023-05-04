package com.groupone.recipeappbackend.user.controller;

import com.groupone.recipeappbackend.user.dto.UserDto;
import com.groupone.recipeappbackend.user.model.UserModel;
import com.groupone.recipeappbackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user/new")
    public String createUserForm(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);
        return "user-registration";
    }

    @PostMapping("/user/new")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("user", userDto);
            return "user-registration";
        }

        userService.saveUser(userDto);
        return "redirect:/login";
    }

}
