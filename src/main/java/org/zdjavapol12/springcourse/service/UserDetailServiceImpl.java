package org.zdjavapol12.springcourse.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zdjavapol12.springcourse.model.User;
import org.zdjavapol12.springcourse.repository.UserRepository;

import java.util.Objects;

// Wlasna implementacja serwisu do zarzadzania uzytkownikami w naszym systemie -> Poki co potrafi tylko zwrocic odpowiedni obiekt.
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
