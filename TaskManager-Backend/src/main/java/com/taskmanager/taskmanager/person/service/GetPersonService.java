package com.taskmanager.taskmanager.person.service;

import com.taskmanager.taskmanager.person.jpa.Person;

@FunctionalInterface
public interface GetPersonService {
    Person  getPerson(Person person);
}
