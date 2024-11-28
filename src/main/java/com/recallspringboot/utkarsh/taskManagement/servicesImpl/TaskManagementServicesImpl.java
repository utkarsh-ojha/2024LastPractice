package com.recallspringboot.utkarsh.taskManagement.servicesImpl;

import com.recallspringboot.utkarsh.taskManagement.entity.Tasks;
import com.recallspringboot.utkarsh.taskManagement.repository.TasksRepository;
import com.recallspringboot.utkarsh.taskManagement.services.TaskManagementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskManagementServicesImpl implements TaskManagementService {

    final
    TasksRepository tasksRepository;

    public TaskManagementServicesImpl(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @Override
    public Tasks createTask(Tasks task) {
        return tasksRepository.save(task);
    }

    @Override
    public Tasks updateTask(Tasks task) {
        return null;
    }

    @Override
    public Boolean deleteTask(long taskId) {
        Optional<Tasks> task = tasksRepository.findById(taskId);
        if (task.isPresent()) {
            tasksRepository.delete(task.get());
            return true;
        }
        return false;
    }

    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }
}
