package hnr.piwnica.backend.controllers;

//import stuff respository and model

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostCreateController {
    @Autowired
    private final PostRepository postRepository;

    public PostCreateController(postRepository postRepo) {
        this.postRepository = postRepo;
    }

    @PostMapping("/create")
    private @ResponseBody String createPost(@RequestParam String text, @RequestParam List<String> tags,
                                            @RequestParam Integer longitude, @RequestParam Integer latitude) {
        Date timeNow = new Date();
        // TODO jak bedzie model postu
        Post post= new Post();
        postRepository.save(post);
        return "Saved";

    }


    @GetMapping("/{post_id}")
    // TODO zmienić typy jak będą
    private Post getPost(@PathVariable Integer id)
    {

    }




    @GetMapping("/{post_id}/comments")
    private Post getPost(@PathVariable Integer id)
    {

    }

    @GetMapping("/recent")
    private List<Post> getPost(@PathVariable Integer id)
    {

    }


    @GetMapping("/featured")
    private List<Post> getPost(@PathVariable Integer id)
    {

    }

    @GetMapping("/near")
    private List<Post> getPost(@PathVariable Integer id)
    {

    }
}
