package com.taskmanager.taskmanager.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PersonOtherDepartmentException extends RuntimeException {

    private static final String OTHER_DEPARTMENT = "Pessoa deve ser do mesmo departamento da tarefa";

    public PersonOtherDepartmentException() {
        super(OTHER_DEPARTMENT);
    }
}
