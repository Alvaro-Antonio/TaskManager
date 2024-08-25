package com.taskmanager.taskmanager.person.service;

import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.department.jpa.DepartmentRepository;
import com.taskmanager.taskmanager.department.exception.DepartmentNotFoundException;
import com.taskmanager.taskmanager.person.dto.PersonDto;
import com.taskmanager.taskmanager.person.dto.PersonUpdateDTO;
import com.taskmanager.taskmanager.person.exception.PersonNotFoundException;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.person.jpa.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UpdatePersonServiceImpl implements UpdatePersonService{

    private final PersonRepository personRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public PersonDto update(Long personId, PersonUpdateDTO personUpdateDTO) {
        Person person = this.personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
        Department department = this.departmentRepository.findById(personUpdateDTO.getDepartmentId()).orElseThrow(DepartmentNotFoundException::new);

        setCampUpdate(person,personUpdateDTO,department);

        return PersonDto.from(this.personRepository.save(person));
    }

    private static void setCampUpdate(Person person, PersonUpdateDTO personUpdateDTO, Department department){
        person.setDepartment(department);
        person.setName(personUpdateDTO.getName());
    }
}
