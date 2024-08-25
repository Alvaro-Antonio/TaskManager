package com.taskmanager.taskmanager.task;

import com.taskmanager.taskmanager.task.services.GetTaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    private GetTaskService getTaskService;

    @GetMapping(value = "/{id}")
    public Task getTask(@RequestParam Long id){
        return this.getTaskService.getTask(id);
    }
}
