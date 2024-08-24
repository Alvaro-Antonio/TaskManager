package com.taskmanager.taskmanager.task.services;

import com.taskmanager.taskmanager.task.Task;

@FunctionalInterface
public interface GetTaskService {
    Task getTask(Long id);
}
