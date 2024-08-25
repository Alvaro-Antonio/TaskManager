package com.taskmanager.taskmanager.task.dto;

import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.task.jpa.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Setter
@AllArgsConstructor
@Getter
public class TaskDTO implements Serializable {

    private static final long serialVersionUID = -483455423900937988L;
    private Long id;

    @NotNull
    @NotBlank
    @Size(max=120)
    private String title;

    @Size(max = 300)
    private String description;

    private LocalDateTime duration;

    @NotNull
    private LocalDateTime deadline;

    private Person personAllocated;

    @NotNull
    private Department department;

    @Value("false")
    private boolean finalized;

    public static TaskDTO from (TaskCreateDTO taskCreateDTO,Department department){
        return TaskDTO.builder()
                .deadline(taskCreateDTO.getDeadline())
                .department(department)
                .description(taskCreateDTO.getDescription())
                .title(taskCreateDTO.getTitle())
                .build();
    }

    public static TaskDTO from (Task task){
        return TaskDTO.builder()
                .id(task.getId())
                .deadline(task.getDeadline())
                .department(task.getDepartment())
                .description(task.getDescription())
                .title(task.getTitle())
                .build();
    }
}
