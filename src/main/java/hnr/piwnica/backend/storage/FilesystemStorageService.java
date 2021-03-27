package hnr.piwnica.backend.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

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

    private String getRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 16;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private String getRandomFilename() {
        String filename;
        do {
            filename = getRandomString();
        } while (root.resolve(filename).normalize().toAbsolutePath().toFile().exists());
        return filename;
    }

    @Override
    public String store(MultipartFile file) {
        try {
            var filename = getRandomFilename();
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

            return filename;
        }
        catch (IOException e) {
            return null;
        }
    }

    @Override
    public Resource load(String filename) throws MalformedURLException {
        Path file = root.resolve(filename);
        return new UrlResource(file.toUri());
    }
}
