package hnr.piwnica.backend.requests;

public class LoginRequest {
    private final String username;
    private final String password;
    private final Boolean rememberMe;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
        this.rememberMe = false;
    }

    public LoginRequest(String username, String password, Boolean rememberMe) {
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }
}
