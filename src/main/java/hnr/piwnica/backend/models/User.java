package hnr.piwnica.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )

    private long userID;
    private String nick;
    private String description;
    private String avatarName;
    public User(long userID, String nick, String description, String avatarName){
        this.userID = userID;
        this.nick = nick;
        this.description = description;
        this.avatarName = avatarName;
    }
    public long getUserID() {
        return userID;
    }
    public void setUserID(long userID) {
        this.userID = userID;
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

}
