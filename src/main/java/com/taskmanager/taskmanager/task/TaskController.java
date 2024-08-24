package com.taskmanager.taskmanager.task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @GetMapping(value = "/{id}")
    public Task getTask(@RequestMapping Long id){

    }
}
