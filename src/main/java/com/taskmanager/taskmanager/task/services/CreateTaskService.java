package com.taskmanager.taskmanager.task.services;

import com.taskmanager.taskmanager.task.dto.TaskCreateDTO;

@FunctionalInterface
public interface CreateTaskService {
    void create(TaskCreateDTO task);
}
