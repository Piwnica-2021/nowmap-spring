package hnr.piwnica.backend.models;

public class Followers {

    private long followedUserID;
    private long followingUserID;

    public long getFollowingUserID() {
        return followingUserID;
    }

    public void setFollowingUserID(long followingUserID) {
        this.followingUserID = followingUserID;
    }

    public long getFollowedUserID() {
        return followedUserID;
    }

    public void setFollowedUserID(long followedUserID) {
        this.followedUserID = followedUserID;
    }

    public Followers( long followedUserID, long followingUserID){
        this.followedUserID = followedUserID;
        this.followingUserID = followingUserID;
    }
}
