package com.sandr.web_library.service.impl;

import com.sandr.web_library.domain.entity.User;
import com.sandr.web_library.domain.exception.ResourceNotFoundException;
import com.sandr.web_library.repository.UserRepository;
import com.sandr.web_library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User with username " + username + " not found")
                );
    }
}
