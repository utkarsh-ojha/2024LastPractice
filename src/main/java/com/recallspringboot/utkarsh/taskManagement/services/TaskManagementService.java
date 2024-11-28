package com.recallspringboot.utkarsh.taskManagement.services;

import com.recallspringboot.utkarsh.taskManagement.dto.TaskRequestDTO;
import com.recallspringboot.utkarsh.taskManagement.dto.TaskResponseDTO;
import com.recallspringboot.utkarsh.taskManagement.entity.Tasks;

import java.util.List;

public interface TaskManagementService {

    public TaskResponseDTO createTask(TaskRequestDTO task);

    public Tasks updateTask(Tasks task);

    public Boolean deleteTask(long taskId);

    public List<Tasks> getAllTasks();
}
