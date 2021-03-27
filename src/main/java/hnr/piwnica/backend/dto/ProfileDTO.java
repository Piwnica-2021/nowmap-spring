package hnr.piwnica.backend.dto;

public class ProfileDTO {
    // null if user set field to private

    public String username;
    public String email;

    public String firstName;
    public String lastName;

    public String avatarUrl;

    public String bio;

    public Integer followers;
    public Integer following;
    public Integer ownLikes;
    public Integer postLikes;
}
