package hnr.piwnica.backend.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    void init() throws IOException;
    String store(MultipartFile file);
    byte[] load(String filename);
}
