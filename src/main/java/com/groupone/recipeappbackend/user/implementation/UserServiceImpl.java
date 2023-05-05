package com.groupone.recipeappbackend.user.implementation;

import com.groupone.recipeappbackend.user.dto.UserDto;
import com.groupone.recipeappbackend.user.helper.PasswordHash;
import com.groupone.recipeappbackend.user.model.UserModel;
import com.groupone.recipeappbackend.user.repository.UserRepository;
import com.groupone.recipeappbackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserModel saveUser(UserDto userDto) {
        userDto.setPassword(PasswordHash.toMd5(userDto.getPassword()));
        return userRepository.save(mapToUser(userDto));
    }

    private UserModel mapToUser(UserDto userDto) {
        UserModel user = new UserModel();

        return UserModel.builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
