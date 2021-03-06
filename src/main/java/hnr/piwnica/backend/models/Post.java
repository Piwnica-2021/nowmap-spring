package hnr.piwnica.backend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )

    private long postID;


    private String title;
  
    @Column(length = 10000)
    private String description;
    private String tags;
    private double longitude;
    private double latitude;
    private Date time;
    private String imgPath;
    private boolean view;
    private Long upvotes;
    @ManyToOne
    private User user;

    public Post(){
        super();
    }
    public Post (long postID, String title, String description, String tags, double longitude, double latitude, Date time, String imgPath, boolean view, Long upvotes){
        super();
        this.postID = postID;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
        this.imgPath = imgPath;
        this.view = view;
        this.upvotes = upvotes;
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
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Long upvotes) {
        this.upvotes = upvotes;
    }


}
