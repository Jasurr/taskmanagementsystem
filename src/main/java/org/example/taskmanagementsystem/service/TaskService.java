package org.example.taskmanagementsystem.service;

import org.example.taskmanagementsystem.dto.AppUserGetDto;
import org.example.taskmanagementsystem.dto.TaskGetDto;
import org.example.taskmanagementsystem.dto.TaskPostDto;
import org.example.taskmanagementsystem.mapper.MapStructMapper;
import org.example.taskmanagementsystem.model.Task;
import org.example.taskmanagementsystem.repository.TaskRepository;
import org.example.taskmanagementsystem.util.UserUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final MapStructMapper mapper;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, MapStructMapper mapper, UserService userService) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
        this.userService = userService;
    }
    public TaskGetDto save(TaskPostDto taskPostDto) {
        Task task = mapper.taskDtoToTaskEntity(taskPostDto);
        taskRepository.save(task);
        return mapper.taskToDto(task);
    }
    public List<TaskGetDto> getAllTasksByUserName() {
        String email = UserUtil.getEmail();
        List<Task> list = taskRepository.findByUserEmail(email);
        return list.stream().map(mapper::taskToDto).toList();
    }


}
