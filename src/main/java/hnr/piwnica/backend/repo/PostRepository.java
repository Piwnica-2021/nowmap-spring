package hnr.piwnica.backend.repo;

import hnr.piwnica.backend.models.Post;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.postID = ?1")
    Post selectPostById(Long post_id);
}
