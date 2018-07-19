package com.cognizant.sharecar.api.resource;

import com.cognizant.sharecar.api.model.TaskView;
import com.cognizant.sharecar.common.spi.model.Priority;
import com.cognizant.sharecar.common.spi.model.TaskStatus;
import org.springframework.scheduling.config.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GetTaskResponse {

    List<TaskView> tasks = new ArrayList<>();

    public GetTaskResponse(List<TaskView> tasks) {
        this.tasks = tasks;
    }

    public GetTaskResponse (TaskView task) {
        tasks.add(task);
    }

    public List<TaskView> getTasks() {
        return tasks;
    }
}
