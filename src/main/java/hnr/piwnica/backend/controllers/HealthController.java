package hnr.piwnica.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/health")
    public Map<String, String> check() {
        return Map.of("status", "ok");
    }
}
