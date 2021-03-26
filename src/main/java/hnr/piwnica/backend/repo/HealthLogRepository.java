package hnr.piwnica.backend.repo;

import hnr.piwnica.backend.models.HealthLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthLogRepository extends JpaRepository<HealthLog, Integer> {
    public HealthLog findTopByOrderByDateDesc();
}
