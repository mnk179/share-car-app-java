package com.cognizant.sharecar.api.spi;

import com.cognizant.sharecar.api.model.request.AddUserRequest;

public interface UserService {

    Long add(AddUserRequest request);

}
