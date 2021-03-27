package hnr.piwnica.backend.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FilesystemStorageService implements StorageService {

    private final Path root;

    @Autowired
    public FilesystemStorageService(StorageProperties properties) {
        this.root = Paths.get(properties.getLocation());
    }

    @Override
    public void init() throws IOException {
        Files.createDirectories(root);
    }

    @Override
    public String store(MultipartFile file) {
        try {
            var filename = file.getOriginalFilename(); // TODO generate random
            if (filename == null)
                return null;

            var dest = this.root.resolve(
                    Paths.get(filename)).normalize().toAbsolutePath();

            if (!dest.getParent().equals(this.root.toAbsolutePath())) {
                return null;
            }

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, dest, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            return null;
        }

        return null;
    }

    @Override
    public byte[] load(String filename) {
        return new byte[0];
    }
}