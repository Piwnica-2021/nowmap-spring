package hnr.piwnica.backend.controllers;

import hnr.piwnica.backend.repo.PostRepository;
import hnr.piwnica.backend.storage.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class ImageController {

    private final StorageService storageService;
    private final PostRepository postRepository;

    public ImageController(StorageService storageService, PostRepository postRepository) {
        this.storageService = storageService;
        this.postRepository = postRepository;
    }

    @PostMapping("/posts/{id}/image")
    String uploadPostImage(@PathVariable long id, @RequestParam("file") MultipartFile file) {
        var post = postRepository.findById(id).orElse(null);
        if (post == null)
            return null;

        var filename = storageService.store(file);
        post.setImgPath(filename);
        postRepository.save(post);

        return filename;
    }

    @GetMapping(
            value = "/posts/{id}/image",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    @ResponseBody
    public ResponseEntity<Resource> getPostImage(@PathVariable long id) {
        var post = postRepository.findById(id).orElse(null);
        if (post == null)
            return null;

        var filename = post.getImgPath();

        try {
            Resource file = storageService.load(filename);
            return ResponseEntity.ok().body(file);
        } catch (Exception e) {
            return null;
        }
    }
}
