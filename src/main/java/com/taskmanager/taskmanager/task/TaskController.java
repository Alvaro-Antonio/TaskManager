package com.taskmanager.taskmanager.task;

import com.taskmanager.taskmanager.person.dto.PersonDto;
import com.taskmanager.taskmanager.task.dto.TaskCreateDTO;
import com.taskmanager.taskmanager.task.dto.TaskDTO;
import com.taskmanager.taskmanager.task.jpa.Task;
import com.taskmanager.taskmanager.task.services.AllocatePersonTask;
import com.taskmanager.taskmanager.task.services.CreateTaskService;
import com.taskmanager.taskmanager.task.services.GetTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {
    private final GetTaskService getTaskService;
    private final CreateTaskService createTaskService;

    private final AllocatePersonTask allocatePersonTask;

    public TaskController(GetTaskService getTaskService, CreateTaskService createTaskService, AllocatePersonTask allocatePersonTask) {
        this.getTaskService = getTaskService;
        this.createTaskService = createTaskService;
        this.allocatePersonTask = allocatePersonTask;
    }

    @GetMapping(value = "/{id}")
    public Task getTask(@PathVariable Long id){
        return this.getTaskService.getTask(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDTO createTask(@RequestBody TaskCreateDTO taskCreateDTO){
        return this.createTaskService.create(taskCreateDTO);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public void allocatePerson(@RequestBody PersonDto personDto, @PathVariable Long id){
        this.allocatePersonTask.allocatePerson(personDto.getId(), id);
    }
}
