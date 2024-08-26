package com.taskmanager.taskmanager.task.services;

import com.taskmanager.taskmanager.person.exception.PersonNotFoundException;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.person.jpa.PersonRepository;
import com.taskmanager.taskmanager.task.exceptions.PersonOtherDepartmentException;
import com.taskmanager.taskmanager.task.exceptions.TaskNotFoundException;
import com.taskmanager.taskmanager.task.jpa.Task;
import com.taskmanager.taskmanager.task.jpa.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AllocatePersonTaskImpl implements AllocatePersonTask{

    private final PersonRepository personRepository;
    private final TaskRepository taskRepository;

    public void allocatePerson(Long personId, Long taskId){
        Person person = this.personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
        Task task = this.taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);

        if(person.getDepartment().equals(task.getDepartment())){
            task.setPersonAllocated(person);
            this.taskRepository.save(task);
        }else {
            throw new PersonOtherDepartmentException();
        }
    }
}
