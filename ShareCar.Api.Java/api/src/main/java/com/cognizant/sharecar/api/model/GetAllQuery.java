package com.cognizant.sharecar.api.model;

import com.cognizant.sharecar.common.spi.model.Priority;
import com.cognizant.sharecar.common.spi.model.TaskStatus;

public class GetAllQuery {

    private TaskStatus status;
    private Priority priority;

    public GetAllQuery(TaskStatus status) {
        this.status = status;
    }

    public GetAllQuery(TaskStatus status, Priority priority) {
        this.status = status;
        this.priority = priority;
    }

    public GetAllQuery(Priority priority) {
        this.priority = priority;
    }

    public GetAllQuery() {}

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }


    public Priority getPriority() {
        return priority;
    }
}
