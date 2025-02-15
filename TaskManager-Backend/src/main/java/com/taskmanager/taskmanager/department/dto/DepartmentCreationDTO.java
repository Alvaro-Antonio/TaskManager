package com.taskmanager.taskmanager.department.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentCreationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 9184773843357575918L;

    @NotBlank
    @NotNull
    private String name;
}
