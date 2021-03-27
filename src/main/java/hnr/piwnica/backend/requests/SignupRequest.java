package hnr.piwnica.backend.requests;

public class SignupRequest {
    private final String username;
    private final String password;

    public SignupRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
