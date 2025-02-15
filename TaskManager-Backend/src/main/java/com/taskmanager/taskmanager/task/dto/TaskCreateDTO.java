package com.taskmanager.taskmanager.task.dto;

import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.task.jpa.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskCreateDTO implements Serializable {

    private static final long serialVersionUID = 3678756368445280655L;

    @NotNull
    @NotBlank
    @Size(max=120)
    private String title;

    @Size(max = 300)
    private String description;

    @NotNull
    private LocalDateTime deadline;

    @NotNull
    private Long departmentId;

    private Person personAllocated;

    public static TaskCreateDTO from (Task task){
        return TaskCreateDTO.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .departmentId(task.getDepartment().getId())
                .personAllocated(task.getPersonAllocated())
                .build();
    }
}
