package com.cognizant.sharecar.service;

import com.cognizant.sharecar.repository.entity.Task;
import com.cognizant.sharecar.repository.spi.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class DefaultTaskService implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskView> getAll(GetAllQuery getAllQuery) {
//        if (getAllQuery.getStatus() != null) {
//            return tasks.stream().filter(task -> task.getStatus() == getAllQuery.getStatus()).collect(toList());
//        }
//        return tasks;
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void add(TaskView task) {
        final Task taskEntity =
                new Task(task.getTitle(), task.getDescription(), task.getEndDate(), task.getStatus(), task.getPriority());
        taskRepository.save(taskEntity);
    }

    @Override
    public void delete(TaskView taskView) {
        final Optional<Task> task = taskRepository.findById(taskView.getTaskId());
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        }
    }

}
