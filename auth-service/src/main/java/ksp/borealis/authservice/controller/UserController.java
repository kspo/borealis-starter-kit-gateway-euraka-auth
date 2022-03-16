package ksp.borealis.authservice.controller;

import ksp.borealis.authservice.dto.UserDto;
import ksp.borealis.authservice.entity.User;
import ksp.borealis.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    public final UserService userService;

    @GetMapping
    public String healthCheck() {
        return "deneme";
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserDto> register(@ModelAttribute UserDto userDto) {
        log.info("kayıt dto: {}", userDto);
        return ResponseEntity.ok().body(userService.saveUser(userDto));
    }
}
