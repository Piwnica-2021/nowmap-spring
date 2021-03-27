package hnr.piwnica.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )

    private long postID;
    private String description;
    private String tags;
    private double longitude;
    private double latitude;
    private String time;
    private String imgPath;
    private boolean view;
    @ManyToOne
    private User user;

    public Post(){
        super();
    }
    public Post (long postID, String description, String tags, double longitude, double latitude, String time, String imgPath, boolean view){
        super();
        this.postID = postID;
        this.description = description;
        this.tags = tags;
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
        this.imgPath = imgPath;
        this.view = view;
    }
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
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
