package com.groupone.recipeappbackend.comment.implementation;

import com.groupone.recipeappbackend.comment.model.Comment;
import com.groupone.recipeappbackend.comment.repository.CommentRepository;
import com.groupone.recipeappbackend.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
