package com.springrest.Main.repository;

import com.springrest.Main.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUserName(String userName);
}
