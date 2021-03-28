package hnr.piwnica.backend.repo;

import hnr.piwnica.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
