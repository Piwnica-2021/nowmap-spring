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

    @GetMapping("/recent")
    public @ResponseBody List<Post> getRecentPosts(@RequestParam Long count, @RequestParam Long last)
    {
        if(last == -1)
        {
            Long lastId = postRepository.selectOffsetPost( 0L ).getPostID();
            List<Post> recentPosts = postRepository.selectRecentPosts(count, lastId);
            return recentPosts;
        }
        else
        {
            List<Post> recentPosts = postRepository.selectRecentPosts(count, last);
            return recentPosts;
        }

    }

    @GetMapping("/recent/last")
    public @ResponseBody Long getRecentLast(@RequestParam Long count, @RequestParam Long last)
    {
        if(last == -1)
        {
            Long lastId = postRepository.selectOffsetPost( 0L ).getPostID();
            List<Post> recentPosts = postRepository.selectRecentPosts(count, lastId);
            int postLength = recentPosts.size();
            Long newLastId = recentPosts.get(postLength - 1).getPostID();
            return newLastId;
        }
        else
        {
            List<Post> recentPosts = postRepository.selectRecentPosts(count, last);
            int postLength = recentPosts.size();
            Long newLastId = recentPosts.get(postLength - 1).getPostID();
            return newLastId;
        }
    }

    @GetMapping("/near")
    public @ResponseBody List<Post> getPost(@RequestParam double lat, @RequestParam double lon)
    {
        List<Post> all_posts = postRepository.selectAllPosts();
        List<Post> near_posts = new ArrayList<Post>();
        double minDistance = 10000;

        for(Post post: all_posts)
        {
            double distance = MathUtil.distanceFromCoordinates(lat, lon, post.getLatitude(), post.getLongitude());

            if(distance < minDistance)
            {
                near_posts.add(post);
            }
        }
        return near_posts;
    }

    @GetMapping("/near/dist")
    public @ResponseBody List<Long> getPostDist(@RequestParam double lat, @RequestParam double lon)
    {
        List<Post> all_posts = postRepository.selectAllPosts();
        List<Long> near_posts_dist = new ArrayList<Long>();
        double minDistance = 10000;

        for(Post post: all_posts)
        {
            double distance = MathUtil.distanceFromCoordinates(lat, lon, post.getLatitude(), post.getLongitude());

            if(distance < minDistance)
            {
                long i = (long) Math.ceil(distance);
                i =  ((i + 99) / 100) * 100;
                near_posts_dist.add(i);
            }
        }
        return near_posts_dist;
    }

}
