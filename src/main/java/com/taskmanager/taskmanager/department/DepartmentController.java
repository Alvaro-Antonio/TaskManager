package com.taskmanager.taskmanager.department;

import com.taskmanager.taskmanager.department.dto.DepartmentCreationDTO;
import com.taskmanager.taskmanager.department.dto.DepartmentDTO;
import com.taskmanager.taskmanager.department.service.CreateDepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final CreateDepartmentService createDepartmentService;

    public DepartmentController(CreateDepartmentService createDepartmentService) {
        this.createDepartmentService = createDepartmentService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public DepartmentDTO createDepartment(@RequestBody DepartmentCreationDTO departmentCreationDTO){
        return this.createDepartmentService.create(departmentCreationDTO);
    }
}
