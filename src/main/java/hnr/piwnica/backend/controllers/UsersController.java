package hnr.piwnica.backend.controllers;

import hnr.piwnica.backend.dto.ProfileDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @GetMapping("/{id}/profile")
    ProfileDTO getProfile(@PathVariable Integer id) {
        return new ProfileDTO();
    }

}
