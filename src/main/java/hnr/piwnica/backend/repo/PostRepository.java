package hnr.piwnica.backend.repo;

import hnr.piwnica.backend.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
