package com.taskmanager.taskmanager.person.jpa;

import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.person.dto.PersonCreationDto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "person_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 150)
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_department")
    private Department department;

    public static Person from (PersonCreationDto personCreationDto, Department department){
        return Person   .builder()
                .department(department)
                .name(personCreationDto.getName())
                .build();

    }
}
