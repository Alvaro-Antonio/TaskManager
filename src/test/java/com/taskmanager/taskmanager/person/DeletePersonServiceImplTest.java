package com.taskmanager.taskmanager.person;

import com.taskmanager.taskmanager.person.exception.PersonNotFoundException;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.person.jpa.PersonRepository;
import com.taskmanager.taskmanager.person.service.DeletePersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DeletePersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private DeletePersonServiceImpl deletePersonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeletePerson_Success() {
        // Given
        Long personId = 1L;
        Person person = new Person();
        person.setId(personId);

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));

        // When
        deletePersonService.delete(personId);

        // Then
        verify(personRepository, times(1)).findById(personId);
        verify(personRepository, times(1)).delete(person);
    }

    @Test
    void testDeletePerson_PersonNotFound() {
        // Given
        Long personId = 1L;

        when(personRepository.findById(personId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(PersonNotFoundException.class, () -> deletePersonService.delete(personId));
        verify(personRepository, times(1)).findById(personId);
        verify(personRepository, never()).delete(any(Person.class));
    }
}

