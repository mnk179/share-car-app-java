package com.cognizant.sharecar.api.resource;

import com.cognizant.sharecar.api.model.request.AddUserRequest;
import com.cognizant.sharecar.api.model.response.AddUserResponse;
import com.cognizant.sharecar.api.spi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserApi{

    @Autowired
    private UserService userService;

    @PostMapping ResponseEntity<AddUserResponse> add(@RequestBody AddUserRequest userRequest){
        try {
            AddUserResponse response = new AddUserResponse(userService.add(userRequest));
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            throw new InternalServerException("Internal error occurred!");
        }
    }
}

