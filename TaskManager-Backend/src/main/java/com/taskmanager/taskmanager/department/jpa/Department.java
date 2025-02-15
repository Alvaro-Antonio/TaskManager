package com.taskmanager.taskmanager.department.jpa;

import com.taskmanager.taskmanager.department.dto.DepartmentCreationDTO;
import com.taskmanager.taskmanager.department.dto.DepartmentDTO;
import com.taskmanager.taskmanager.person.jpa.Person;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department implements Serializable {

    private static final long serialVersionUID = -6588652737748343960L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_generator")
    @SequenceGenerator(name = "department_generator", sequenceName = "department_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Person> people;

    public static Department from (DepartmentDTO departmentDTO){
        return Department.builder()
                .id(departmentDTO.getId())
                .name(departmentDTO.getName())
                .build();
    }

    public static Department from (DepartmentCreationDTO departmentDTO){
        return Department.builder()
                .name(departmentDTO.getName())
                .build();
    }
}
