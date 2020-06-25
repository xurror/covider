package cm.ubuea.covider.profile_module.dto;

public class AuthRequestBody {
    private String username;
    private String password;

    public AuthRequestBody() {

    }

    public AuthRequestBody(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
