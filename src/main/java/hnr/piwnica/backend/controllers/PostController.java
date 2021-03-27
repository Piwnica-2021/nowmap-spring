package hnr.piwnica.backend.controllers;

import hnr.piwnica.backend.requests.CreatePostRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepo) {
        postRepository = postRepo;
    }

    @PostMapping("/create")
    public Object createPost(@RequestBody CreatePostRequest request) {
        var date = new Date();
        var ownerId = 0; // TODO get logged in user id

        return new Object();
    }

}
