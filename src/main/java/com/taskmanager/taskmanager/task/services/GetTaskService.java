package com.taskmanager.taskmanager.task.services;

import com.taskmanager.taskmanager.task.jpa.Task;

@FunctionalInterface
public interface GetTaskService {
    Task getTask(Long id);
}
