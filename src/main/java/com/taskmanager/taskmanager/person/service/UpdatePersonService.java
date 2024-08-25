package com.taskmanager.taskmanager.person.service;

import com.taskmanager.taskmanager.person.jpa.Person;

@FunctionalInterface
public interface UpdatePersonService {
    Person  update(Person person);
}
