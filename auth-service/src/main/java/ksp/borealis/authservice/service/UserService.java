package ksp.borealis.authservice.service;

import ksp.borealis.authservice.dto.UserDto;
import ksp.borealis.authservice.entity.User;
import ksp.borealis.authservice.repository.UserRepository;
import ksp.borealis.authservice.utils.ModelConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public UserDto saveUser(UserDto userDto){
        log.info("User saved to DB: {}", userDto.getFirstName());
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userRepository.save(ModelConverter.map(userDto, User.class));
        return ModelConverter.map(user, UserDto.class);
    }

    public List<UserDto> getUsers(){
        List<User> users = userRepository.findAll();
        return ModelConverter.mapAll(users, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null) {
            log.error("User cannot found in db {}", username);
            throw new UsernameNotFoundException("User cannot found in db ${username}");
        } else {
            log.error("User found in db {}", user);
        }

        Collection <SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRole().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
