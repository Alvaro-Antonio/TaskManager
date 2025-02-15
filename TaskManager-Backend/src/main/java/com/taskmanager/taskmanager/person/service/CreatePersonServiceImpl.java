package com.taskmanager.taskmanager.person.service;

import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.department.jpa.DepartmentRepository;
import com.taskmanager.taskmanager.department.exception.DepartmentNotFoundException;
import com.taskmanager.taskmanager.person.dto.PersonCreationDto;
import com.taskmanager.taskmanager.person.dto.PersonDto;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.person.jpa.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreatePersonServiceImpl implements CreatePersonService{

    private final PersonRepository personRepository;
    private final DepartmentRepository departmentRepository;
    @Override
    public PersonDto create(PersonCreationDto person) {
        Department department = this.departmentRepository.findById(person.getDepartmentId()).orElseThrow(DepartmentNotFoundException::new);

        Person person1 = Person.from(person,department);
        return PersonDto.from(this.personRepository.save(person1));
    }
}
