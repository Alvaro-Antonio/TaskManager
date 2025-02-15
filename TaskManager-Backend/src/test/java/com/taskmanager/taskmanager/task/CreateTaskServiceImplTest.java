package com.taskmanager.taskmanager.task;

import com.taskmanager.taskmanager.department.dto.DepartmentDTO;
import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.department.jpa.DepartmentRepository;
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

class CreateTaskServiceImplTest {

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
        Long departmentId = 1L;
        Long personId = 1L;
        PersonCreationDto personCreationDto = new PersonCreationDto();
        personCreationDto.setDepartmentId(departmentId);
        personCreationDto.setName("John Doe");

        Department department = new Department();
        department.setId(departmentId);

        Person person = new Person();
        person.setId(personId);
        person.setName("John Doe");
        person.setDepartment(department);

        PersonDto personDto = new PersonDto();
        personDto.setId(personId);
        personDto.setName("John Doe");
        personDto.setDepartment(DepartmentDTO.from(department));

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));
        when(personRepository.save(any(Person.class))).thenReturn(person);

        // When
        PersonDto result = createPersonService.create(personCreationDto);

        // Then
        assertNotNull(result);
        assertEquals(personId, result.getId());
        assertEquals("John Doe", result.getName());
        verify(departmentRepository, times(1)).findById(departmentId);
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void testCreatePersonDepartmentNotFound() {
        // Given
        Long departmentId = 1L;
        PersonCreationDto personCreationDto = new PersonCreationDto();
        personCreationDto.setDepartmentId(departmentId);

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(DepartmentNotFoundException.class, () -> createPersonService.create(personCreationDto));
        verify(departmentRepository, times(1)).findById(departmentId);
        verify(personRepository, never()).save(any(Person.class));
    }
}

