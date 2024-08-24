package com.taskmanager.taskmanager.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException {

    private static final String TASK_NOT_FOUND = "Tarefa não Encontrada!";

    public TaskNotFoundException() {
        super(TASK_NOT_FOUND);
    }
}
