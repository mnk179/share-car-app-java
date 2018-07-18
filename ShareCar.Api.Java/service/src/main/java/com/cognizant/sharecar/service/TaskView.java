package com.cognizant.sharecar.service;

import com.cognizant.sharecar.common.spi.model.Priority;
import com.cognizant.sharecar.common.spi.model.TaskStatus;

import java.time.LocalDateTime;

public class TaskView {

    private Long taskId;
    private String title;
    private String description;
    private LocalDateTime endDate;
    private TaskStatus status;
    private Priority priority;

    public TaskView() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }


}
