package com.taskmanager.taskmanager.person.service;

import com.taskmanager.taskmanager.person.jpa.Person;

@FunctionalInterface
public interface DeletePersonService {
    void  create(Person person);
}
