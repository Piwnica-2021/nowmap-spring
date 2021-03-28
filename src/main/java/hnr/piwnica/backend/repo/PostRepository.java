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
            value = "select * from post p " +
                    "order by p.time desc",
            nativeQuery = true)
    public List<Post> selectRecentPosts();

    @Query(
            value = "select * from post p " +
                    "order by p.postID desc " +
                    "limit 1 " +
                    "offset 0",
            nativeQuery = true)
    public Post selectOffsetPost(Long offset);


    @Query(
            value = "select * from post p",
            nativeQuery = true)
    public List<Post> selectAllPosts();

    @Query(
            value = "select * from post p order by p.upvotes desc",
            nativeQuery = true)
    public List<Post> selectAllPostsOrderUpvotes();

    @Query(
            value = "update post p set p.upvotes = p.upvotes + 1 where p.postID = ?1",
            nativeQuery = true)
    public void updatePostUpvoted(Long post_id);
}
