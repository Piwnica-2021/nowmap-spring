package hnr.piwnica.backend.models;

public class LikeDetails {
    private long userID;
    private long postID;
    private String likeType;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    public String getLikeType() {
        return likeType;
    }

    public void setLikeType(String likeType) {
        this.likeType = likeType;
    }

    public LikeDetails(long userID, long postID, String likeType) {
        this.likeType = likeType;
        this.userID = userID;
        this.postID = postID;
    }
}
