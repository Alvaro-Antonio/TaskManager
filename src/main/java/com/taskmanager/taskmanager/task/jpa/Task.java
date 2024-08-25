package com.taskmanager.taskmanager.task.jpa;


import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.person.jpa.Person;
import com.taskmanager.taskmanager.task.dto.TaskCreateDTO;
import com.taskmanager.taskmanager.task.dto.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_generator")
    @SequenceGenerator(name = "task_generator", sequenceName = "task_sequence", allocationSize = 1)
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

    @OneToOne
    private Person personAllocated;

    @OneToOne
    @NotNull
    private Department department;

    @Value("false")
    private boolean finalized;

    public static Task from (TaskCreateDTO taskCreateDTO, Department department){
        return Task.builder()
                .title(taskCreateDTO.getTitle())
                .description(taskCreateDTO.getTitle())
                .deadline(taskCreateDTO.getDeadline())
                .department(department)
                .build();
    }

    public static Task from (TaskDTO taskDTO, Department department){
        return Task.builder()
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .deadline(taskDTO.getDeadline())
                .department(department)
                .build();
    }
}
