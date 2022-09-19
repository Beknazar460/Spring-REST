package com.springrest.Main.model;

import com.springrest.Main.entity.ToDoEntity;

public class ToDoModel {
    private Long id;
    private String title;
    private Boolean completed;

    public static ToDoModel toDoModel(ToDoEntity toDoEntity) {
        ToDoModel toDoModel = new ToDoModel();
        toDoModel.setId(toDoEntity.getId());
        toDoModel.setTitle(toDoEntity.getTitle());
        toDoModel.setCompleted(toDoEntity.isCompleted());
        return toDoModel;
    }

    public ToDoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
