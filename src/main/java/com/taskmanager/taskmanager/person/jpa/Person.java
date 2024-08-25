package com.taskmanager.taskmanager.person.jpa;

import com.taskmanager.taskmanager.department.Department;
import com.taskmanager.taskmanager.department.dto.DepartmentDTO;
import com.taskmanager.taskmanager.person.dto.PersonCreationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

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
        return Person.builder()
                .department(department)
                .name(personCreationDto.getName())
                .build();

    }
}
