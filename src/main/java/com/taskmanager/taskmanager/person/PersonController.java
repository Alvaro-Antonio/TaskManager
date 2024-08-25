package com.taskmanager.taskmanager.person;

import com.taskmanager.taskmanager.person.dto.PersonCreationDto;
import com.taskmanager.taskmanager.person.dto.PersonDto;
import com.taskmanager.taskmanager.person.dto.PersonUpdateDTO;
import com.taskmanager.taskmanager.person.service.CreatePersonService;
import com.taskmanager.taskmanager.person.service.DeletePersonService;
import com.taskmanager.taskmanager.person.service.UpdatePersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private final CreatePersonService createPersonService;
    private final UpdatePersonService updatePersonService;

    private final DeletePersonService deletePersonService;

    public PersonController(CreatePersonService createPersonService, UpdatePersonService updatePersonService, DeletePersonService deletePersonService) {
        this.createPersonService = createPersonService;
        this.updatePersonService = updatePersonService;
        this.deletePersonService = deletePersonService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public PersonDto createPerson(@RequestBody PersonCreationDto personCreationDto){
        return this.createPersonService.create(personCreationDto);
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @PutMapping(value = "/{personId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto updatePerson(@PathVariable Long personId, @RequestBody PersonUpdateDTO personUpdateDTO){
        return this.updatePersonService.update(personId, personUpdateDTO);
    }

    @DeleteMapping(value = "/{idPerson}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deletePerson(@PathVariable Long idPerson){
        this.deletePersonService.delete(idPerson);
    }
}
