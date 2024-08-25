package com.taskmanager.taskmanager.person.service;

import com.taskmanager.taskmanager.department.Department;
import com.taskmanager.taskmanager.department.DepartmentRepository;
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
    public PersonDto create(Person person) {
        Department department = this.departmentRepository.save(person.getDepartment());
        this.personRepository.save(person);
        return PersonDto.from(this.personRepository.save(person));
    }
}
