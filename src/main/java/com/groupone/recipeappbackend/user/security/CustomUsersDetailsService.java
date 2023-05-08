package com.groupone.recipeappbackend.user.security;

import com.groupone.recipeappbackend.user.model.UserModel;
import com.groupone.recipeappbackend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUsersDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    @Autowired
    public CustomUsersDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        UserModel user = userRepository.findFirstByEmail(email);
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
