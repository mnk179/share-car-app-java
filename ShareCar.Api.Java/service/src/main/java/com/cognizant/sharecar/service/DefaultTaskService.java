package com.cognizant.sharecar.service;

import com.cognizant.sharecar.api.model.request.AddTaskRequest;
import com.cognizant.sharecar.api.model.request.GetAllQuery;
import com.cognizant.sharecar.api.model.dto.LazyTaskView;
import com.cognizant.sharecar.api.model.dto.TaskView;
import com.cognizant.sharecar.api.spi.TaskService;
import com.cognizant.sharecar.repository.entity.Task;
import com.cognizant.sharecar.repository.spi.TaskRepository;
import com.cognizant.sharecar.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Task> tasks = new ArrayList<>();
//        if (getAllQuery.getStatus() != null) {
//            return tasks.stream().filter(task -> task.getStatus() == getAllQuery.getStatus()).collect(toList());
//        }
//        return tasks;
        throw new RuntimeException("Not implemented");
    }

    @Override
    public TaskView getOne(Long id) {
        final Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            TaskView taskView = new TaskView();
            taskView.setId(task.getTaskId());
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
    public LazyTaskView add(AddTaskRequest request) {
        final TaskView requestTask = request.getTask();
        final Task taskEntity = new Task(requestTask.getTitle(),
                                         requestTask.getDescription(),
                                         requestTask.getEndDate(),
                                         requestTask.getStatus(),
                                         requestTask.getPriority());
        Task detachedEntity = taskRepository.save(taskEntity);
        return new LazyTaskView(detachedEntity.getTaskId());
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