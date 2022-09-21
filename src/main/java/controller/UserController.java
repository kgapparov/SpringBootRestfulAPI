package controller;

import dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private  final UserService service;

    @GetMapping("/{username}")
    public ResponseEntity getUser(@PathVariable String username) {
        return ResponseEntity.ok(service.readUserByUsername(username));
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) {
        service.createUser(user);
        return ResponseEntity.ok().build();
    }
}
