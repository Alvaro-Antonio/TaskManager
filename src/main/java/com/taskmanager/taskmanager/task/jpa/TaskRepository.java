package com.taskmanager.taskmanager.task.jpa;

import com.taskmanager.taskmanager.task.jpa.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Override
    Optional<Task> findById(Long id);
}
