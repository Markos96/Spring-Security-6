package com.markos96.security.controller;

import com.markos96.security.model.domain.Users;
import com.markos96.security.model.dto.SignupRequestDTO;
import com.markos96.security.service.RolService;
import com.markos96.security.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/signup")
public class SignupController {

    private UserService userService;

    private RolService rolService;

    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<User> signup(@RequestBody SignupRequestDTO signupRequestDTO) {

        Users user = new Users();
        String passwordEncode = passwordEncoder.encode(signupRequestDTO.getPassword());

        user.setUsername(signupRequestDTO.getUsername());
        user.setPassword(passwordEncode);
        user.setRoles(List.of(rolService.getRolByName("ROLE_ADMIN")));

        userService.save(user);

        return ResponseEntity.accepted().build();
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRolService(RolService rolService) {
        this.rolService = rolService;
    }
}
