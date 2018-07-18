package com.cognizant.sharecar.service;

import com.cognizant.sharecar.common.spi.model.TaskStatus;

public class GetAllQuery {

    private TaskStatus status;

    public GetAllQuery(TaskStatus status) {
        this.status = status;
    }

    public GetAllQuery() {}

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
