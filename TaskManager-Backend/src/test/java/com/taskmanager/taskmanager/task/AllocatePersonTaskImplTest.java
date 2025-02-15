package com.taskmanager.taskmanager.task;

import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.person.jpa.PersonRepository;
import com.taskmanager.taskmanager.task.exceptions.PersonOtherDepartmentException;
import com.taskmanager.taskmanager.task.jpa.Task;
import com.taskmanager.taskmanager.task.jpa.TaskRepository;
import com.taskmanager.taskmanager.task.services.AllocatePersonTaskImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class AllocatePersonTaskImplTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private AllocatePersonTaskImpl allocatePersonTask;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAllocatePersonSuccess() {
        // Given
        Long personId = 1L;
        Long taskId = 1L;

        Person person = new Person();
        person.setId(personId);
        Department department = new Department();
        department.setId(1L);
        person.setDepartment(department);

        Task task = new Task();
        task.setId(taskId);
        task.setDepartment(department);

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        // When
        allocatePersonTask.allocatePerson(personId, taskId);

        // Then
        verify(taskRepository, times(1)).save(task);
        assertEquals(person, task.getPersonAllocated());
    }

    @Test
    void testAllocatePersonThrowsPersonOtherDepartmentException() {
        // Given
        Long personId = 1L;
        Long taskId = 1L;

        Person person = new Person();
        person.setId(personId);
        Department personDepartment = new Department();
        personDepartment.setId(1L);
        person.setDepartment(personDepartment);

        Task task = new Task();
        task.setId(taskId);
        Department taskDepartment = new Department();
        taskDepartment.setId(2L);
        task.setDepartment(taskDepartment);

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        // When & Then
        assertThrows(PersonOtherDepartmentException.class, () -> allocatePersonTask.allocatePerson(personId, taskId));

        verify(taskRepository, never()).save(any(Task.class));
    }
}

