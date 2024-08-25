package com.taskmanager.taskmanager.department.dto;


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
public class DepartmentCreationDTO implements Serializable {


    private static final long serialVersionUID = 9184773843357575918L;

    @NotBlank
    @NotNull
    private String name;
}
