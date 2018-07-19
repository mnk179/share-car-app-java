package com.cognizant.sharecar.api.resource;

import com.cognizant.sharecar.api.model.TaskView;
import com.cognizant.sharecar.api.spi.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/tasks")
public class TaskApi {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public AddTaskResponse add(@RequestBody TaskView taskView) {
        try {
            taskService.add(taskView);
        } catch (Exception exception) {
            // TODO: add logging
            throw new InternalServerException("Internal error occurred!");
        }
        AddTaskResponse addTaskResponse = new AddTaskResponse();
        addTaskResponse.setId(1);
        addTaskResponse.setSuccessfullyAdded(true);
        return addTaskResponse;
    }
}
