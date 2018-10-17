package com.cognizant.sharecar.service;

import com.cognizant.sharecar.api.model.dto.UserView;
import com.cognizant.sharecar.api.model.request.AddUserRequest;
import com.cognizant.sharecar.api.spi.UserService;
import com.cognizant.sharecar.repository.entity.User;
import com.cognizant.sharecar.repository.spi.UserRepository;
import com.cognizant.sharecar.service.exception.NotFoundException;
import com.cognizant.sharecar.service.utils.UserMapper;
import org.springframework.stereotype.Service;


@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserView getOne(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::mapEntityToView)
                .orElseThrow(() -> new NotFoundException("User with id " + id + " was not found"));
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
