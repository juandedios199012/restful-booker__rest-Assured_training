package model.login;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {

    @JsonProperty("username")
    private final String username;
    @JsonProperty("password")
    private final String password;

    public Login() {
        this.username = "admin";
        this.password = "password123";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}