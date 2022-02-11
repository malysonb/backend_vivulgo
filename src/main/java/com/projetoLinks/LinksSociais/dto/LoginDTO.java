package com.projetoLinks.LinksSociais.dto;

import javax.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message = "Login não pode ficar vazio!")
    private String login;

    @NotBlank(message = "Senha não pode ficar vazia!")
    private String senha;

    public LoginDTO() {
    }

    public LoginDTO(@NotBlank(message = "Login não pode ficar vazio!") String login,
            @NotBlank(message = "Senha não pode ficar vazia!") String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
