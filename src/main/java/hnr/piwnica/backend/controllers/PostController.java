package hnr.piwnica.backend.controllers;

import hnr.piwnica.backend.models.Post;
import hnr.piwnica.backend.repo.PostRepository;
import hnr.piwnica.backend.repo.UserRepository;
import hnr.piwnica.backend.requests.CreatePostRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostController(PostRepository postRepo, UserRepository userRepo) {
        postRepository = postRepo;
        userRepository = userRepo;
    }

    @PostMapping("/create")
    public long createPost(@RequestBody CreatePostRequest request) {
        var date = new Date();
        var ownerId = 0; // TODO get logged in user id

        var post = new Post();
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());
        post.setLatitude(request.getLatitude());
        post.setLongitude(request.getLongitude());
//        post.setTags();
        post.setTime(date);
//        post.setUser();

        post = postRepository.save(post);

        return post.getPostID();
    }

    @GetMapping("/{post_id}")
    public @ResponseBody
    Post getPost(@PathVariable Long post_id)
    {
        return postRepository.selectPostById(post_id);
    }

    @GetMapping("/recent/{count}")
    public @ResponseBody
    List<Post> getRecentPosts(@PathVariable Long count)
    {
        return postRepository.selectRecentPosts(count);
    }

//    @GetMapping("/near")
//    private List<Post> getPost(@PathVariable Integer id)
//    {
//        all_posts = postRepository.selectAllPosts();
//    }

}
