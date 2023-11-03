package com.gianpc.app.models.domain;

import jakarta.validation.constraints.*;

public class Usuario {

    private Integer id;
    @NotBlank
    private String username;
    @Size(min = 3,max = 6)
    private String password;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private Pais pais;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
