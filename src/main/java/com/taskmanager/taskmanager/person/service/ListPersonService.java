package com.taskmanager.taskmanager.person.service;

import com.taskmanager.taskmanager.person.jpa.Person;

import java.util.List;

@FunctionalInterface
public interface ListPersonService {
    List<Person> list();
}
