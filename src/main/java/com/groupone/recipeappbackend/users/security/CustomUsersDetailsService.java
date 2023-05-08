package com.groupone.recipeappbackend.users.security;

import com.groupone.recipeappbackend.users.model.Users;
import com.groupone.recipeappbackend.users.repository.UsersRepository;
import com.groupone.recipeappbackend.users.service.UsersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUsersDetailsService implements UsersDetailsService {
    private UsersRepository usersRepository;
    @Autowired
    public CustomUsersDetailsService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }



    public User loadUserByUsername(String username) throws UsernameNotFoundException{
        Users user = usersRepository.findFirstByUsername(username);
        if (user != null){
            User authUser = new User(
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList())

            );
            return authUser;
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }

    }
}
