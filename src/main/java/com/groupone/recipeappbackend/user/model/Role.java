package com.groupone.recipeappbackend.user.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Value("${role.name:Client}")
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private List<UserModel> users = new ArrayList<>();
}
