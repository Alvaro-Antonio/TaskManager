package com.taskmanager.taskmanager.person;

import com.taskmanager.taskmanager.department.Department;
import com.taskmanager.taskmanager.department.DepartmentRepository;
import com.taskmanager.taskmanager.department.dto.DepartmentDTO;
import com.taskmanager.taskmanager.department.exception.DepartmentNotFoundException;
import com.taskmanager.taskmanager.person.dto.PersonCreationDto;
import com.taskmanager.taskmanager.person.dto.PersonDto;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.person.jpa.PersonRepository;
import com.taskmanager.taskmanager.person.service.CreatePersonServiceImpl;
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
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class CreatePersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private CreatePersonServiceImpl createPersonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePersonSuccess() {
        // Given
        PersonCreationDto personCreationDto = new PersonCreationDto();
        personCreationDto.setDepartmentId(1L);
        personCreationDto.setName("John Doe");

        Department department = new Department();
        department.setId(1L);

        Person person = new Person();
        person.setId(1L);
        person.setName("John Doe");
        person.setDepartment(department);

        PersonDto personDto = new PersonDto(1L, "John Doe", DepartmentDTO.from(department));

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
        when(personRepository.save(any(Person.class))).thenReturn(person);

        // When
        PersonDto result = createPersonService.create(personCreationDto);

        // Then
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals(1L, result.getDepartment().getId());
        verify(departmentRepository, times(1)).findById(1L);
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void testCreatePersonDepartmentNotFound() {
        // Given
        PersonCreationDto personCreationDto = new PersonCreationDto();
        personCreationDto.setDepartmentId(1L);

        when(departmentRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(DepartmentNotFoundException.class, () -> createPersonService.create(personCreationDto));
        verify(departmentRepository, times(1)).findById(1L);
        verify(personRepository, never()).save(any(Person.class));
    }
}

