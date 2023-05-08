package com.groupone.recipeappbackend.users.repository;

import com.groupone.recipeappbackend.users.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
