package hnr.piwnica.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthLogRepository extends JpaRepository<HealthLog, Integer> {
    public HealthLog findTopByOrderByDateDesc();
}
