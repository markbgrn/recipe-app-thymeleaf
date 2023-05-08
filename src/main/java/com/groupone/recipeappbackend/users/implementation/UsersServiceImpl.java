package com.groupone.recipeappbackend.users.implementation;

import com.groupone.recipeappbackend.users.dto.LoginFormDto;
import com.groupone.recipeappbackend.users.model.Users;
import com.groupone.recipeappbackend.users.repository.RoleRepository;
import com.groupone.recipeappbackend.users.repository.UsersRepository;
import com.groupone.recipeappbackend.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersServiceImpl implements UsersService{
    private UsersRepository usersRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, RoleRepository roleRepository){
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;

    }
    @Override
    public Users loginUser(LoginFormDto loginFormDto) {
        return null;
    }

    @Override
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
