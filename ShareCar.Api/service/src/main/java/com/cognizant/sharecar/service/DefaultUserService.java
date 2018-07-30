package com.cognizant.sharecar.service;

import com.cognizant.sharecar.api.model.request.AddUserRequest;
import com.cognizant.sharecar.api.spi.UserService;
import com.cognizant.sharecar.repository.entity.User;
import com.cognizant.sharecar.repository.spi.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long add(AddUserRequest request) {
        final User userEntity = new User(request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPhoneNo());
        return userRepository.save(userEntity).getId();
    }
}
