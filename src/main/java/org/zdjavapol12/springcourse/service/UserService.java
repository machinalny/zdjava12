package org.zdjavapol12.springcourse.service;

import org.zdjavapol12.springcourse.model.User;

import java.util.List;

public interface UserService {

    User createNewUser(User user);

    List<User> getAllUsers();

}
