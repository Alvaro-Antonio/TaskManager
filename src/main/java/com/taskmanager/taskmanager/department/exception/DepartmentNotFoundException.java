package com.taskmanager.taskmanager.department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException{
    public static final String DEPARTMENT_NOT_FOUND = "Departamento não encontrado!";

    public DepartmentNotFoundException(){
        super(DEPARTMENT_NOT_FOUND);
    }
}
