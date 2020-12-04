package org.zdjavapol12.springcourse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.zdjavapol12.springcourse.model.User;
import org.zdjavapol12.springcourse.service.UserService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api")
public class UserRestController {

    private final UserService userService;

//    private final AuthenticationManager authenticationManager;
//    private final JwtTokenProvider jwtTokenProvider;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerNewUser(@RequestBody User user){
        User createdUser = userService.createNewUser(user);
        if (Objects.isNull(createdUser)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


//    @PostMapping("/signin")
//    public ResponseEntity<?> signIn(@RequestBody User data) {
//        try {
//            String username = data.getUsername();
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
//            User user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User  " + username + "not found"));
//            TokenObject preparedToken = jwtTokenProvider.createToken(username, user.getRoles());
//            return ResponseEntity.ok(JwtResponse.builder().token(preparedToken.getToken()).username(username).expiration(preparedToken.getValidity()).type("Bearer").userId(user.getId()).build());
//        } catch (AuthenticationException e) {
//            throw new BadCredentialsException("Invalid username/password supplied");
//        }
//    }
}
