package com.groupone.recipeappbackend.user.implementation;

import com.groupone.recipeappbackend.user.dto.UserDto;
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
        return userRepository.save(mapToUser(userDto));
    }

    private UserModel mapToUser(UserDto userDto) {
        UserModel user = new UserModel();

        return UserModel.builder()
                .email(userDto.getEmail())
                .build();
    }
}
