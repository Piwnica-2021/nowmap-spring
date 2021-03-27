package hnr.piwnica.backend.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface StorageService {
    void init() throws IOException;
    String store(MultipartFile file);
    Resource load(String filename) throws MalformedURLException;
}
