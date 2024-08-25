package com.taskmanager.taskmanager.person;

import com.taskmanager.taskmanager.person.dto.PersonCreationDto;
import com.taskmanager.taskmanager.person.dto.PersonDto;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.person.service.CreatePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private CreatePersonService createPersonService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public PersonDto createPerson(@RequestBody PersonCreationDto personCreationDto){
        return this.createPersonService.create(Person.from(personCreationDto));
    }
}
