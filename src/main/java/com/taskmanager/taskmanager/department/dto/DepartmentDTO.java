package com.taskmanager.taskmanager.department.dto;

import com.taskmanager.taskmanager.department.jpa.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO implements Serializable {

    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    public static DepartmentDTO from (Department department){
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .build();
    }
}