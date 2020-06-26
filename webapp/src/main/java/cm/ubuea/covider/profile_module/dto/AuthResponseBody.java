package cm.ubuea.covider.profile_module.dto;

public class AuthResponseBody {
    private String token;

    public AuthResponseBody(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
