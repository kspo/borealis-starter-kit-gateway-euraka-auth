package ksp.borealis.authservice.service;

import ksp.borealis.authservice.dto.UserDto;
import ksp.borealis.authservice.entity.User;
import ksp.borealis.authservice.repository.UserRepository;
import ksp.borealis.authservice.utils.ModelConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<UserDto> getUsers(){
        List<User> users = userRepository.findAll();
        return ModelConverter.mapAll(users, UserDto.class);
    }
}
