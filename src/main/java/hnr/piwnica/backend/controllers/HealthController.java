package hnr.piwnica.backend.controllers;

import hnr.piwnica.backend.models.HealthLog;
import hnr.piwnica.backend.repo.HealthLogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
public class HealthController {
    private final HealthLogRepository healthLog;

    public HealthController(HealthLogRepository healthLogRepository) {
        this.healthLog = healthLogRepository;
    }

    @GetMapping("/health")
    public Map<String, String> check() {
        var lastCheck = healthLog.findTopByOrderByDateDesc();
        healthLog.save(new HealthLog(new Date()));
        return Map.of(
                "status", "ok",
                "lastCheck", lastCheck.getDate().toString()
        );
    }
}
