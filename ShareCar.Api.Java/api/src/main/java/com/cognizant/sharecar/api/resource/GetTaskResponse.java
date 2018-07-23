package com.cognizant.sharecar.api.resource;

import com.cognizant.sharecar.api.model.dto.TaskView;
import com.cognizant.sharecar.api.model.response.ResponseWrapper;

public class GetTaskResponse implements ResponseWrapper {

    private TaskView taskView;

    public GetTaskResponse(TaskView taskView) {
        this.taskView = taskView;
    }

    public TaskView getTaskView() {
        return taskView;
    }

    public void setTaskView(TaskView taskView) {
        this.taskView = taskView;
    }
}
