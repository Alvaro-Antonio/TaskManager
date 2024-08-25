package com.taskmanager.taskmanager.person.dto;

import com.taskmanager.taskmanager.department.dto.DepartmentDTO;
import com.taskmanager.taskmanager.person.jpa.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Builder
public class PersonDto implements Serializable {
    private Long id;

    @NotNull
    @NotBlank
    private String name;
    private DepartmentDTO department;

    public static PersonDto from (Person person){
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .department(DepartmentDTO.from(person.getDepartment()))
                .build();
    }
}