package com.taskmanager.taskmanager.department.service;

import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.department.jpa.DepartmentRepository;
import com.taskmanager.taskmanager.department.dto.DepartmentCreationDTO;
import com.taskmanager.taskmanager.department.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDepartmentServiceImpl implements CreateDepartmentService{

    private final DepartmentRepository departmentRepository;
    public DepartmentDTO create(DepartmentCreationDTO departmentDTO){
        return DepartmentDTO.from(this.departmentRepository.save(Department.from(departmentDTO)));
    }
}
