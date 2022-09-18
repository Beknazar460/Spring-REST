package com.springrest.Main.model;

import com.springrest.Main.entity.UserEntity;

public class UserModel {
    private Long id;
    private String userName;

    public static UserModel toModel(UserEntity entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        return model;
    }

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
