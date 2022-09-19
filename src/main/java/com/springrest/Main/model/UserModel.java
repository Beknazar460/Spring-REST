package com.springrest.Main.model;

import com.springrest.Main.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {
    private Long id;
    private String userName;
    private List<ToDoModel> toDoS;

    public static UserModel toModel(UserEntity entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        model.setToDoS(entity.getTodo().stream().map(ToDoModel::toDoModel).collect(Collectors.toList()));
        return model;
    }

    public UserModel() {
    }

    public List<ToDoModel> getToDoS() {
        return toDoS;
    }

    public void setToDoS(List<ToDoModel> toDoS) {
        this.toDoS = toDoS;
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
