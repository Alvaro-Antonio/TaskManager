package com.taskmanager.taskmanager.task.services;

import com.taskmanager.taskmanager.department.exception.DepartmentNotFoundException;
import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.department.jpa.DepartmentRepository;
import com.taskmanager.taskmanager.task.dto.TaskDTO;
import com.taskmanager.taskmanager.task.jpa.Task;
import com.taskmanager.taskmanager.task.jpa.TaskRepository;
import com.taskmanager.taskmanager.task.dto.TaskCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTaskServiceImpl implements CreateTaskService {
    private final TaskRepository taskRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public TaskDTO create(TaskCreateDTO task) {
        Department department = this.departmentRepository.findById(task.getDepartmentId()).orElseThrow(DepartmentNotFoundException::new);

        TaskDTO task1 = TaskDTO.from(task , department);
        return TaskDTO.from(this.taskRepository.save(Task.from(task1,department)));
    }
}