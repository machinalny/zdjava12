package org.zdjavapol12.springcourse.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.zdjavapol12.springcourse.model.User;
import org.zdjavapol12.springcourse.repository.UserRepository;

import java.util.Objects;

@Component
@Slf4j
public class TestRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public TestRunner(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        if (Objects.isNull(userRepository.findByUsername("Lukasz"))){
            User user = User.builder()
                    .username("Lukasz")
                    .password(bCryptPasswordEncoder.encode("password"))
                    .enabled(true)
                    .role("ROLE_ADMIN").build();
            userRepository.save(user);
        }


    }
}
