package com.taskmanager.taskmanager.task.services;

import com.taskmanager.taskmanager.task.Task;
import com.taskmanager.taskmanager.task.TaskRepository;
import com.taskmanager.taskmanager.task.exceptions.TaskNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTaskServiceImpl implements GetTaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task getTask(Long id) {
        return this.taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }
}
