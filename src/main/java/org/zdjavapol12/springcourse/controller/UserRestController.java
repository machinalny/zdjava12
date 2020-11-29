package org.zdjavapol12.springcourse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zdjavapol12.springcourse.model.User;
import org.zdjavapol12.springcourse.service.UserService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<?> registerNewUser(@RequestBody User user){
        User createdUser = userService.createNewUser(user);
        if (Objects.isNull(createdUser)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

}
