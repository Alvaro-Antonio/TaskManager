package com.taskmanager.taskmanager.task.services;

import com.taskmanager.taskmanager.task.dto.TaskCreateDTO;
import com.taskmanager.taskmanager.task.dto.TaskDTO;

@FunctionalInterface
public interface CreateTaskService {
    TaskDTO create(TaskCreateDTO task);
}
