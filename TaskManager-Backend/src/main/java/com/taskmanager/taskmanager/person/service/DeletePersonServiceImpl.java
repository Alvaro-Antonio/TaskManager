package com.taskmanager.taskmanager.person.service;

import com.taskmanager.taskmanager.person.exception.PersonNotFoundException;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.person.jpa.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePersonServiceImpl implements DeletePersonService{
    private final PersonRepository personRepository;
    public void  delete(Long id){
        Person person = this.personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        this.personRepository.delete(person);
    }
}
