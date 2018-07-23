package com.cognizant.sharecar.api.resource;

import com.cognizant.sharecar.api.model.dto.LazyTaskView;
import com.cognizant.sharecar.api.model.dto.TaskView;
import com.cognizant.sharecar.api.model.request.AddTaskRequest;
import com.cognizant.sharecar.api.model.response.AddTaskResponse;
import com.cognizant.sharecar.api.spi.TaskService;
import com.cognizant.sharecar.api.util.ApiUtil;
import com.cognizant.sharecar.api.util.GetIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/tasks")
public class TaskApi implements GetIdentifier {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<AddTaskResponse> add(@RequestBody AddTaskRequest taskRequest) {
        try {
            LazyTaskView lazyTaskView = taskService.add(taskRequest);
            AddTaskResponse response = new AddTaskResponse();
            // ADD link to the API
            response.add(ApiUtil.getHrefForGet(lazyTaskView.getId(), this.getClass()));
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            throw new InternalServerException("Internal error occurred!");
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GetTaskResponse> getOne(@PathVariable(name = "id") long id){
        TaskView task = taskService.getOne(id);
        return ResponseEntity.ok(new GetTaskResponse(task));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        try {
            taskService.delete(id);
        } catch (Exception exception) {
            throw new InternalServerException("Internal error occurred!");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
