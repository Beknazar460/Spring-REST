package com.springrest.Main.service;

import com.springrest.Main.entity.ToDoEntity;
import com.springrest.Main.entity.UserEntity;
import com.springrest.Main.model.ToDoModel;
import com.springrest.Main.repository.ToDoRepo;
import com.springrest.Main.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    ToDoRepo toDoRepo;
    @Autowired
    UserRepo userRepo;

    public ToDoModel createToDo(ToDoEntity toDo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        toDo.setUser(user);
        return ToDoModel.toDoModel(toDoRepo.save(toDo));
    }

    public ToDoModel updateToDo(Long id) {
        ToDoEntity toDo = toDoRepo.findById(id).get();
         toDo.setCompleted(!toDo.isCompleted());
        return ToDoModel.toDoModel(toDoRepo.save(toDo));

    }
}
