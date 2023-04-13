package com.groupone.recipeappbackend.comment.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment")
    @Lob
    private String userComment;
}
