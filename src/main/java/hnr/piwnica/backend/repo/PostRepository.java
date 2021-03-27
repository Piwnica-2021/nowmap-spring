package hnr.piwnica.backend.repo;

import hnr.piwnica.backend.models.Post;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.postID = ?1")
    public Post selectPostById(Long post_id);

    @Query(
            value = "select * from post p order by p.time desc limit ?1",
            nativeQuery = true)
    public List<Post> selectRecentPosts(Long count);
}
