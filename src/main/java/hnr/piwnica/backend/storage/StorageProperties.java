package hnr.piwnica.backend.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "imageDir";

    public StorageProperties() {
        var root = System.getenv("MAPTALK_STORAGE_DIR");
        if (root == null || root.equals("")) {
            root = System.getProperty("java.io.tmpdir") + "/maptalk-data";
            System.out.println("Using temp dir");
        }
        location = root;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
