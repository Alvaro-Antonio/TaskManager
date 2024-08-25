package com.taskmanager.taskmanager.person.dto;

import com.taskmanager.taskmanager.department.Department;
import com.taskmanager.taskmanager.person.jpa.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO for {@link Person}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonCreationDto implements Serializable {

    private static final long serialVersionUID = 770169666782881749L;
    @NotNull
    @NotBlank
    private String name;

   @NotNull
   private Long departmentId;
}