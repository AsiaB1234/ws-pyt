package pyt.controller.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignUpDto {

    @NotNull
    @Size(min = 1)
    private String email;
    @NotNull
    @Size(min = 1)
    private String password;
    @NotNull
    @Size(min = 1)
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
