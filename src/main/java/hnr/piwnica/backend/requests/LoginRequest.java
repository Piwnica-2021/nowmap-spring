package hnr.piwnica.backend.requests;

public class LoginRequest {
    private String username;
    private String password;
    private Boolean rememberMe;

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
