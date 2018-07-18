package com.cognizant.sharecar.service;

import com.cognizant.sharecar.common.spi.model.TaskStatus;

public class Task {
    private TaskStatus status;
    private int id;

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
