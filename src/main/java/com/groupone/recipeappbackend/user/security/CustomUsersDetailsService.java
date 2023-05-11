package com.groupone.recipeappbackend.user.security;

import com.groupone.recipeappbackend.user.model.UserModel;
import com.groupone.recipeappbackend.user.repository.UserRepository;
import com.groupone.recipeappbackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Service
public class CustomUsersDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    private UserService userService;

    private HttpSession session;
    @Autowired
    public CustomUsersDetailsService(UserService userService, HttpSession session){
        this.userService = userService;
        this.session = session;
    }




    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        UserModel user = userService.findByEmail(email);

        if (user != null){
            boolean isEnabled = user.getIsVerified();
            User authUser = new User(
                    user.getEmail(),
                    user.getPassword(),
                    isEnabled,
                     true, true, true,
                    user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList())

            );
            session.setAttribute("user", authUser);

            return authUser;
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }

    }
}
