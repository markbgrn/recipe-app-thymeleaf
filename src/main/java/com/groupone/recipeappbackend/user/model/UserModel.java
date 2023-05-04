package com.groupone.recipeappbackend.user.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
    @ManyToMany
    @JoinTable(
            name = "user_security_questions",
            joinColumns = @JoinColumn(name = "user.id"),
            inverseJoinColumns = @JoinColumn(name = "security_questions.id"))
    Set<SecurityQuestion> userSecurityQuestions;
}
