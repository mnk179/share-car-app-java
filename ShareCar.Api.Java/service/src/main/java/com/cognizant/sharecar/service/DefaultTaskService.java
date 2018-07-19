package com.cognizant.sharecar.service;

import com.cognizant.sharecar.api.model.GetAllQuery;
import com.cognizant.sharecar.api.model.TaskView;
import com.cognizant.sharecar.api.spi.TaskService;
import com.cognizant.sharecar.repository.entity.Task;
import com.cognizant.sharecar.repository.spi.TaskRepository;
import com.cognizant.sharecar.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultTaskService implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public DefaultTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskView> getAll(GetAllQuery getAllQuery) {
//        if (getAllQuery.getStatus() != null) {
//            return tasks.stream().filter(task -> task.getStatus() == getAllQuery.getStatus()).collect(toList());
//        }
//        return tasks;
        throw new RuntimeException("Not implemented");
    }

    @Override
    public TaskView getOne(long id) {
        //throw new RuntimeException("Not implemented");
        TaskView taskView = new TaskView();

        final Optional<Task> task = taskRepository.findById(id);

        if (task.isPresent()) {
            Task taskObject = task.get();
            taskView.setTaskId(taskObject.getTaskId());
            taskView.setDescription(taskObject.getDescription());
            taskView.setEndDate(taskObject.getEndDate());
            taskView.setPriority(taskObject.getPriority());
            taskView.setStatus(taskObject.getStatus());
            taskView.setTitle(taskObject.getTitle());
        }
        else {
            throw new NotFoundException("Task with id " + id + " was not found");
        }

        return taskView;
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
        }
        else {
            throw new NotFoundException("Task with id " + id + " was not found");
        }
    }
}