package com.taskmanager.taskmanager.task.dto;

import java.time.LocalDateTime;

public class TaskCreateDTO {
    private String name;
    private String description;
    private LocalDateTime deadline;
    private LocalDateTime duration;
}
