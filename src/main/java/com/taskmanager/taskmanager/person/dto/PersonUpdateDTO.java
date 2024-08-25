package com.taskmanager.taskmanager.person.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonUpdateDTO implements Serializable {

    private static final long serialVersionUID = 2674131188361976663L;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Long departmentId;
}