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

import java.util.*;

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
        var ownerId = 0;

        var post = new Post();
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());
        post.setLatitude(request.getLatitude());
        post.setLongitude(request.getLongitude());
        post.setTags(request.getTags());
        post.setTime(date);
//        post.setUser();

        post = postRepository.save(post);

        return post.getPostID();
    }

    @PostMapping("/{post_id}/like")
    public @ResponseBody Post upvotePost(@PathVariable Long post_id)
    {
        postRepository.updatePostUpvoted(post_id);
        return postRepository.selectPostById(post_id);

    }

    @GetMapping("/{post_id}")
    public @ResponseBody Post getPost(@PathVariable Long post_id)
    {
        return postRepository.selectPostById(post_id);
    }

    @GetMapping("/recent")
    public @ResponseBody List<Post> getRecentPosts()
    {
        List<Post> recentPosts = postRepository.selectRecentPosts();
        return recentPosts;
    }

    @GetMapping("/dist")
    public @ResponseBody Map<Long, Long> getPostsDistane(@RequestParam double lat, @RequestParam double lon)
    {
        List<Post> all_posts = postRepository.selectAllPosts();
        List<Long> posts_dist = new ArrayList<Long>();
        Map<Long, Long> map = new HashMap<>();

        for(Post post: all_posts)
        {
            double distance = MathUtil.distanceFromCoordinates(lat, lon, post.getLatitude(), post.getLongitude());


            long i = (long) Math.ceil(distance);
            i =  ((i + 99) / 100) * 100;
            posts_dist.add(i);
            map.put(post.getPostID(), i);
        }
        return map;
    }

    @GetMapping("/near")
    public @ResponseBody List<Post> getNearPost(@RequestParam double lat, @RequestParam double lon, @RequestParam double radius)
    {
        List<Post> all_posts = postRepository.selectAllPosts();
        List<Post> near_posts = new ArrayList<Post>();
        List<Long> near_posts_dist = new ArrayList<Long>();
        double minDistance = radius;

        Map<Long, Post> map = new HashMap<>();

        for(Post post: all_posts)
        {
            double distance = MathUtil.distanceFromCoordinates(lat, lon, post.getLatitude(), post.getLongitude());

            if(distance < minDistance)
            {
                near_posts.add(post);
                long i = (long) Math.ceil(distance);
                i =  ((i + 99) / 100) * 100;
                near_posts_dist.add(i);
                map.put(i, post);
            }
        }
//        map.entrySet()
//                .stream()
//                .sorted(Map.Entry.<Long, Post>comparingByKey())
//                .forEach(System.out::println);

        return near_posts;
    }

    @GetMapping("/featured")
    public @ResponseBody List<Post> getFeaturedPost(@RequestParam Long upvotes)
    {
        List<Post> all_posts = postRepository.selectAllPostsOrderUpvotes();
        List<Post> featured_posts = new ArrayList<Post>();
        double minUpvotes = upvotes;

        for(Post post: all_posts)
        {
            Long postUpvotes = post.getUpvotes();
            if(postUpvotes > minUpvotes)
            {
                featured_posts.add(post);
            }
        }
        return featured_posts;
    }

}
