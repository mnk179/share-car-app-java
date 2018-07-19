package com.cognizant.sharecar.service;

import com.cognizant.sharecar.api.model.GetAllQuery;
import com.cognizant.sharecar.api.model.TaskView;
import com.cognizant.sharecar.api.spi.TaskService;
import com.cognizant.sharecar.common.spi.model.Priority;
import com.cognizant.sharecar.common.spi.model.TaskStatus;
import com.cognizant.sharecar.repository.entity.Task;
import com.cognizant.sharecar.repository.spi.TaskRepository;
import com.cognizant.sharecar.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultTaskService implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public DefaultTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskView> getAll(GetAllQuery getAllQuery) {
        List<Task> tasks;
        final TaskStatus status = getAllQuery.getStatus();
        final Priority priority = getAllQuery.getPriority();

        if (status == null && priority == null) {
            tasks = taskRepository.findAll();
        } else if (status == null) {
            tasks = taskRepository.findByPriority(priority);
        } else if (priority == null) {
            tasks = taskRepository.findByStatus(status);
        } else {
            tasks = taskRepository.findByStatusAndPriority(status, priority);
        }
        return tasks.stream()
                .map(task ->
                        new TaskView(task.getTaskId(),
                                task.getTitle(),
                                task.getDescription(),
                                task.getEndDate(),
                                task.getStatus(),
                                task.getPriority()))
                .collect(toList());
    }

    @Override
    public TaskView getOne(Long id) {
        final Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            TaskView taskView = new TaskView();
            taskView.setTaskId(task.getTaskId());
            taskView.setTitle(task.getTitle());
            taskView.setDescription(task.getDescription());
            taskView.setEndDate(task.getEndDate());
            taskView.setStatus(task.getStatus());
            taskView.setPriority(task.getPriority());
            return taskView;
        }
        throw new NotFoundException("Task with id " + id + " was not found");
    }

    @Override
    public void add(TaskView task) {
        final Task taskEntity =
                new Task(task.getTitle(), task.getDescription(), task.getEndDate(), task.getStatus(), task.getPriority());
        taskRepository.save(taskEntity);
    }

    @Override
    public void delete(long id) {
        final Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        } else {
            throw new NotFoundException("Task with id " + id + " was not found");
        }
    }
}