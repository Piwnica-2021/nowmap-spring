package hnr.piwnica.backend.controllers;

import hnr.piwnica.backend.models.Post;
import hnr.piwnica.backend.utils.MathUtil;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
    public Object createPost(@RequestBody CreatePostRequest request) {
        var date = new Date();
        var ownerId = 0; // TODO get logged in user id

        return new Object();
    }

    @GetMapping("/{post_id}")
    public @ResponseBody Post getPost(@PathVariable Long post_id)
    {
        return postRepository.selectPostById(post_id);
    }

    @GetMapping("/recent/{count}")
    public @ResponseBody List<Post> getRecentPosts(@PathVariable Long count)
    {
        return postRepository.selectRecentPosts(count);
    }

    @GetMapping("/near")
    public @ResponseBody List<Post> getPost(@RequestParam double lat, @RequestParam double lon)
    {
        List<Post> all_posts = postRepository.selectAllPosts();
        List<Post> near_posts = new ArrayList<Post>();
        double minDistance = 5000;

        for(Post post: all_posts)
        {

            double distance = MathUtil.distanceFromCoordinates(lat, lon, post.getLatitude(), post.getLongitude());
            System.out.println(lat);
            System.out.println(lon);
            System.out.println(post.getLatitude());
            System.out.println(post.getLongitude());
            System.out.println(distance);
            System.out.println();

            if(distance < minDistance)
            {
                near_posts.add(post);
            }
        }
        return near_posts;
    }

}
