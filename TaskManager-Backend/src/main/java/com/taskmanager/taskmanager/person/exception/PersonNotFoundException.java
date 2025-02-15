package com.taskmanager.taskmanager.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException{
    public static final String PERSON_NOT_FOUND = "Pessoa não encontrado!";

    public PersonNotFoundException(){
        super(PERSON_NOT_FOUND);
    }
}
