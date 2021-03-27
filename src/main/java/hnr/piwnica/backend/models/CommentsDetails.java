package hnr.piwnica.backend.models;

public class CommentsDetails {
    private long userID;
    private long postID;
    private String commentText;

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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public CommentsDetails(long userID, long postID, String commentText) {
        this.commentText = commentText;
        this.userID = userID;
        this.postID = postID;
    }
}
