package org.zdjavapol12.springcourse.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.zdjavapol12.springcourse.model.User;
import org.zdjavapol12.springcourse.repository.UserRepository;

import java.util.List;
import java.util.Objects;

// Wlasna implementacja serwisu do zarzadzania uzytkownikami w naszym systemie -> Poki co potrafi tylko zwrocic odpowiedni obiekt.
@Service
public class UserDetailServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // Uzywane przez Spring Security to sprawdzenia czy dany uzytkownik istnieje -> Jesli tak to oczekuje zwrocenie obiektu
    // UserDetails na podstwie ktorego tworzy Principal.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("Nie znaleziono uzytkownika o loginie " + username);
        }

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
                user.getEnabled(), true, true, true,
                AuthorityUtils.createAuthorityList(user.getRole()));
    }

    @Override
    public User createNewUser(User user) {
        if (Objects.isNull(userRepository.findByUsername(user.getUsername()))){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            if(Objects.isNull(user.getEnabled())){
                user.setEnabled(true);
            }
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> user.setPassword(null));
        return users;
    }
}
