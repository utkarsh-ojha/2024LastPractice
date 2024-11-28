package com.recallspringboot.utkarsh.taskManagement.controller;

import com.recallspringboot.utkarsh.taskManagement.entity.Tasks;
import com.recallspringboot.utkarsh.taskManagement.servicesImpl.TaskManagementServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskManagementController {

    @Autowired
    TaskManagementServicesImpl taskManagementServices;

    @PostMapping("/createTask")
    public ResponseEntity<Tasks> createTask(Tasks tasks) {
        return new ResponseEntity<>(taskManagementServices.createTask(tasks), HttpStatus.CREATED);
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Tasks>> getAllTasks() {
        return new ResponseEntity<>(taskManagementServices.getAllTasks(), HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
        return new ResponseEntity<>(taskManagementServices.deleteTask(id), HttpStatus.GONE);
    }

}
