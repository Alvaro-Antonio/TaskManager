package com.taskmanager.taskmanager.person.service;

import com.taskmanager.taskmanager.person.dto.PersonCreationDto;
import com.taskmanager.taskmanager.person.dto.PersonDto;
import com.taskmanager.taskmanager.person.jpa.Person;

@FunctionalInterface
public interface CreatePersonService {
    PersonDto create(PersonCreationDto person);
}
