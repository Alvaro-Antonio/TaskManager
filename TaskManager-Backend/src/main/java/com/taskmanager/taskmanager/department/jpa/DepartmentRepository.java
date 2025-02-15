package com.taskmanager.taskmanager.department.jpa;

import com.taskmanager.taskmanager.department.jpa.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
