package com.recallspringboot.utkarsh.taskManagement.services;

import com.recallspringboot.utkarsh.taskManagement.entity.Tasks;

import java.util.List;

public interface TaskManagementService {

    public Tasks createTask(Tasks task);

    public Tasks updateTask(Tasks task);

    public Boolean deleteTask(long taskId);

    public List<Tasks> getAllTasks();
}
