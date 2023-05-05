package com.groupone.recipeappbackend.users.controller;
import com.groupone.recipeappbackend.users.dto.LoginFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller

public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("loginForm", LoginFormDto.builder().build());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("loginForm") LoginFormDto loginForm, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("loginForm", loginForm);
            return "login";
        }
//        recipeService.saveRecipe(recipeDto); Create login service for LoginFormDto
        return "redirect:/recipes";
    }
}
