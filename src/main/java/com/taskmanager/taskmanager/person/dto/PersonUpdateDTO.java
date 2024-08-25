package com.taskmanager.taskmanager.person.dto;

import com.taskmanager.taskmanager.department.dto.DepartmentDTO;
import com.taskmanager.taskmanager.person.jpa.Person;
import lombok.Value;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link Person}
 */
@Value
public class PersonUpdateDTO implements Serializable {

    @NotNull
    String name;

    @NotNull
    DepartmentDTO department;
}