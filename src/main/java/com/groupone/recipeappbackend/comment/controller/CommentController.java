package com.groupone.recipeappbackend.comment.controller;

import com.groupone.recipeappbackend.comment.model.Comment;
import com.groupone.recipeappbackend.comment.repository.CommentRepository;
import com.groupone.recipeappbackend.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    /*private final CommentService commentService;*/
    @Autowired
    private CommentRepository commentRepository;


    @GetMapping("/comments")
    public String getComments(Model model) {
        List<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        return "comments";

    }



}
