package com.taskmanager.taskmanager.person;

import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.department.jpa.DepartmentRepository;
import com.taskmanager.taskmanager.department.exception.DepartmentNotFoundException;
import com.taskmanager.taskmanager.person.dto.PersonDto;
import com.taskmanager.taskmanager.person.dto.PersonUpdateDTO;
import com.taskmanager.taskmanager.person.exception.PersonNotFoundException;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.person.jpa.PersonRepository;
import com.taskmanager.taskmanager.person.service.UpdatePersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class UpdatePersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private UpdatePersonServiceImpl updatePersonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdatePersonSuccess() {
        // Given
        Long personId = 1L;
        PersonUpdateDTO personUpdateDTO = new PersonUpdateDTO();
        personUpdateDTO.setName("John Doe Updated");
        personUpdateDTO.setDepartmentId(1L);

        Person existingPerson = new Person();
        existingPerson.setId(personId);
        existingPerson.setName("John Doe");

        Department department = new Department();
        department.setId(1L);

        when(personRepository.findById(personId)).thenReturn(Optional.of(existingPerson));
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
        when(personRepository.save(any(Person.class))).thenReturn(existingPerson);

        // When
        PersonDto result = updatePersonService.update(personId, personUpdateDTO);

        // Then
        assertNotNull(result);
        assertEquals("John Doe Updated", result.getName());
        assertEquals(1L, result.getDepartment().getId());
        verify(personRepository, times(1)).findById(personId);
        verify(departmentRepository, times(1)).findById(1L);
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void testUpdatePersonPersonNotFound() {
        // Given
        Long personId = 1L;
        PersonUpdateDTO personUpdateDTO = new PersonUpdateDTO();
        personUpdateDTO.setDepartmentId(1L);

        when(personRepository.findById(personId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(PersonNotFoundException.class, () -> updatePersonService.update(personId, personUpdateDTO));
        verify(personRepository, times(1)).findById(personId);
        verify(departmentRepository, never()).findById(anyLong());
        verify(personRepository, never()).save(any(Person.class));
    }

    @Test
    void testUpdatePersonDepartmentNotFound() {
        // Given
        Long personId = 1L;
        PersonUpdateDTO personUpdateDTO = new PersonUpdateDTO();
        personUpdateDTO.setDepartmentId(1L);

        Person existingPerson = new Person();
        existingPerson.setId(personId);

        when(personRepository.findById(personId)).thenReturn(Optional.of(existingPerson));
        when(departmentRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(DepartmentNotFoundException.class, () -> updatePersonService.update(personId, personUpdateDTO));
        verify(personRepository, times(1)).findById(personId);
        verify(departmentRepository, times(1)).findById(1L);
        verify(personRepository, never()).save(any(Person.class));
    }
}
