package com.sandr.web_library.service;

import com.sandr.web_library.domain.entity.User;

public interface UserService {

    User getById(Integer id);

    User create(User user);

    User update(User user);

    User getByUsername(String username);
}
