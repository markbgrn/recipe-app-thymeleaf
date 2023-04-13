package com.groupone.recipeappbackend.comment.controller;

import com.groupone.recipeappbackend.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

}
