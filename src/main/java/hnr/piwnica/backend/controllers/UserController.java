package hnr.piwnica.backend.controllers;

import hnr.piwnica.backend.dto.ProfileDTO;
import hnr.piwnica.backend.requests.LoginRequest;
import hnr.piwnica.backend.requests.SignupRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("/profile")
    ProfileDTO getProfile() {
        return new ProfileDTO();
    }

    @PostMapping("/login")
    Object login(@RequestBody LoginRequest form) {
        return new Object();
    }

    @PostMapping("/logout")
    Object logout() {
        return new Object();
    }

    @PostMapping("/signup")
    Object signup(@RequestBody SignupRequest form) {
        return new Object();
    }

}
