package com.groupone.recipeappbackend.user.implementation;

import com.groupone.recipeappbackend.user.dto.LoginFormDto;
import com.groupone.recipeappbackend.user.dto.UserDto;
import com.groupone.recipeappbackend.user.helper.Md5Hash;
import com.groupone.recipeappbackend.user.model.UserModel;
import com.groupone.recipeappbackend.user.repository.RoleRepository;
import com.groupone.recipeappbackend.user.repository.UserRepository;
import com.groupone.recipeappbackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(UserRepository usersRepository, RoleRepository roleRepository) {
        this.userRepository = usersRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserModel saveUser(UserDto userDto) {
        userDto.setPassword(Md5Hash.toMd5(userDto.getPassword()));
        userDto.setVerificationId(Md5Hash.toMd5(userDto.getEmail()));
        userDto.setIsVerified(false);
        return userRepository.save(mapToUser(userDto));
    }

    @Override
    public void updateUser(UserDto userDto) {
        UserModel user = mapToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public void setUserVerified(String verificationId) {
        UserModel user = userRepository.findByVerificationId(verificationId);
        user.setIsVerified(true);
        userRepository.save(user);
    }

    @Override
    public UserModel loginUser(LoginFormDto loginFormDto) {
        return null;
    }

    @Override
    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private UserModel mapToUser(UserDto userDto) {
        UserModel user = new UserModel();

        return UserModel.builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .verificationId(userDto.getVerificationId())
                .isVerified(userDto.getIsVerified())
                .build();
    }
}
