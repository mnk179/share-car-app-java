package com.cognizant.sharecar.api.spi;

import com.cognizant.sharecar.api.model.dto.UserView;
import com.cognizant.sharecar.api.model.request.AddUserRequest;

public interface UserService {

    UserView getOne(Long id);

    Long add(AddUserRequest request);

}
