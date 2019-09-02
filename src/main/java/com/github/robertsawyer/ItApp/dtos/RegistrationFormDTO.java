package com.github.robertsawyer.ItApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationFormDTO {  //klasa zawierajaca pola niezbędne do obsługi formularza // obiekt do transferu danych między warstwami aplikacji

    @NotNull
    @Size(min = 3, max = 20)
    private String login;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 3, max = 20)
    private String password;
    @NotNull
    @Size(min = 3, max = 20)
    private String confirmPassword;
//    @NotBlank
//    private String firstName;
//    @NotBlank
//    private String lastName;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
