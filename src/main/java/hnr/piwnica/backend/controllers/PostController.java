package hnr.piwnica.backend.controllers;

import hnr.piwnica.backend.repo.PostRepository;
import hnr.piwnica.backend.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepo) {
        this.postRepository = postRepo;
    }


    @GetMapping("/{post_id}")
    public @ResponseBody Post getPost(@PathVariable Long post_id)
    {
        return postRepository.selectPostById(post_id);
    }



//    @GetMapping("/recent")
//    private List<Post> getPost(@PathVariable Integer id)
//    {
//
//    }


//    @GetMapping("/featured")
//    private List<Post> getPost(@PathVariable Integer id)
//    {
//
//    }

//    @GetMapping("/near")
//    private List<Post> getPost(@PathVariable Integer id)
//    {
//
//    }
}
