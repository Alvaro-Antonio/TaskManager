package com.taskmanager.taskmanager.department.service;

import com.taskmanager.taskmanager.department.dto.DepartmentCreationDTO;
import com.taskmanager.taskmanager.department.dto.DepartmentDTO;

@FunctionalInterface
public interface CreateDepartmentService {
    DepartmentDTO create(DepartmentCreationDTO departmentCreationDTO);
}
