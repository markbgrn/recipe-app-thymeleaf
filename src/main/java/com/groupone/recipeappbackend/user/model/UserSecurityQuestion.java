package com.groupone.recipeappbackend.user.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users_security_questions")
public class UserSecurityQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="users.id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name="security_questions.id", nullable = false)
    private SecurityQuestion securityQuestion;
}
