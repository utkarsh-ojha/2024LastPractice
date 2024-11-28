package com.recallspringboot.utkarsh.taskManagement.servicesImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recallspringboot.utkarsh.taskManagement.dto.Assineee;
import com.recallspringboot.utkarsh.taskManagement.dto.TaskRequestDTO;
import com.recallspringboot.utkarsh.taskManagement.dto.TaskResponseDTO;
import com.recallspringboot.utkarsh.taskManagement.entity.Tasks;
import com.recallspringboot.utkarsh.taskManagement.repository.TasksRepository;
import com.recallspringboot.utkarsh.taskManagement.services.TaskManagementService;
import com.recallspringboot.utkarsh.userManagement.entity.Users;
import com.recallspringboot.utkarsh.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskManagementServicesImpl implements TaskManagementService {

    @Autowired
    UserRepository userRepository;
    final TasksRepository tasksRepository;


    public TaskManagementServicesImpl(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO taskDetails) {
        Users myLinkedUser = userRepository.findById(taskDetails.getAssignedToUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Tasks task = new Tasks();
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        task.setPriority(taskDetails.getPriority());
        task.setAssignedToUser(myLinkedUser);
        Tasks savedTask = tasksRepository.save(task);

        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setId(savedTask.getId());
        taskResponseDTO.setTitle(savedTask.getTitle());
        taskResponseDTO.setStatus(savedTask.getPriority());
        taskResponseDTO.setDueDate(savedTask.getDueDate());

        Assineee assineee = new Assineee();
        assineee.setId(savedTask.getAssignedToUser().getId());
        assineee.setName(taskResponseDTO.getTitle());
        taskResponseDTO.setAssigedTo(assineee);
        return taskResponseDTO;

    }

    @Override
    public Tasks updateTask(Tasks task) {
        return null;
    }

    @Override
    public Boolean deleteTask(long taskId) {
        Optional<Tasks> task = tasksRepository.findById(taskId);
        if (task.isPresent()) {
            tasksRepository.deleteById(taskId);
            return true;
        }
        return false;
    }

    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }
}
