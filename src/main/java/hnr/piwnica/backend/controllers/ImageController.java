package hnr.piwnica.backend.controllers;

import hnr.piwnica.backend.storage.StorageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class ImageController {

    private final StorageService storageService;

    public ImageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/posts/{id}/image")
    String uploadPostImage(@PathVariable Integer id, @RequestParam("file") MultipartFile file) {
        return storageService.store(file);
    }

    @GetMapping(
            value = "/posts/{id}/image",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getPostImage(@PathVariable Integer id) {
        return new byte[0];
    }

}
