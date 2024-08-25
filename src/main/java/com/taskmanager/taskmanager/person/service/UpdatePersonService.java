package com.taskmanager.taskmanager.person.service;

import com.taskmanager.taskmanager.person.dto.PersonDto;
import com.taskmanager.taskmanager.person.dto.PersonUpdateDTO;

@FunctionalInterface
public interface UpdatePersonService {
    PersonDto update(Long personId, PersonUpdateDTO person);
}
