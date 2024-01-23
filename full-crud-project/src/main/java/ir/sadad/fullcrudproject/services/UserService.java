package ir.sadad.fullcrudproject.services;


import ir.sadad.fullcrudproject.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);

    UserEntity getUserById(Long userId);

    List<UserEntity> getAllUsers();

    UserEntity updateUser(UserEntity user);

    void deleteUser(Long userId);
}