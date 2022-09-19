package com.springrest.Main.service;

import com.springrest.Main.entity.UserEntity;
import com.springrest.Main.exception.UserAlreadyExistException;
import com.springrest.Main.exception.UserNotFoundException;
import com.springrest.Main.model.UserModel;
import com.springrest.Main.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity createUser(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUserName(user.getUserName()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public UserModel getOneUser(Long id) throws UserNotFoundException{
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return UserModel.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }

}
