package hnr.piwnica.backend.requests;

import java.util.List;

public class CreatePostRequest {
    private String title;
    private String description;
    private String tags;
    private Double latitude;
    private Double longitude;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTags() {
        return tags;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
