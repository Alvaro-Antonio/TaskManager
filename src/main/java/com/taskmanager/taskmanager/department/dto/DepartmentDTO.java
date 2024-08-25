package com.taskmanager.taskmanager.department.dto;

import com.taskmanager.taskmanager.department.Department;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.taskmanager.taskmanager.department.Department}
 */
@Value
@Builder
public class DepartmentDTO implements Serializable {
    Long id;
    String name;

    public static DepartmentDTO from (Department department){
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .build();
    }
}