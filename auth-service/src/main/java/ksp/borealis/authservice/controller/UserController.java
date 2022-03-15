package ksp.borealis.authservice.controller;

import ksp.borealis.authservice.dto.UserDto;
import ksp.borealis.authservice.entity.User;
import ksp.borealis.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping
    public String healthCheck() {
        return "deneme";
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
}
