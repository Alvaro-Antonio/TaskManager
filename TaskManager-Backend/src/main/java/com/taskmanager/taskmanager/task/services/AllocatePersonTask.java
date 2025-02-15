package com.taskmanager.taskmanager.task.services;

@FunctionalInterface
public interface AllocatePersonTask {
    void allocatePerson(Long personId, Long taskId);
}
