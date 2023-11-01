package com.gianpc.app.models.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Usuario {
    @NotBlank(message = "Debes ingresar el dato solicitado")
    private String username;
    @Size(min = 3,max = 6, message = "Debes de usar de 3 a 6 caracteres")
    private String password;
    @NotBlank(message = "Debes ingresar el dato solicitado")
    @Email(message = "Debes ingresar un correo con formato correcto (@)")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
