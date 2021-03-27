package hnr.piwnica.backend.models;

import javax.persistence.Entity;

@Entity
public class Post {
    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    private long postID;
    private String description;
    private String tags;
    private double longitude;
    private double latitude;
    private String time;
    private String imgPath;
    private boolean view;
    private long ownerID;

    public Post (long postID, String description, String tags, double longitude, double latitude, String time, String imgPath, boolean view, long ownerID){
        this.postID = postID;
        this.description = description;
        this.tags = tags;
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
        this.imgPath = imgPath;
        this.view = view;
        this.ownerID = ownerID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }
    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }





}
