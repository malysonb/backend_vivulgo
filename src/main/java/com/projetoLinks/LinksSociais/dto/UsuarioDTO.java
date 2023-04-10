package com.projetoLinks.LinksSociais.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UsuarioDTO {
    
    @NotBlank(message ="Login" + "{not.blank}")
    @NotNull(message = "Login" + "{not.null}")
    private String login;

    @NotBlank(message ="Nome" + "{not.blank}")
    @NotNull(message = "Nome" + "{not.null}")
    private String nome;

    @NotBlank(message ="Email" + "{not.blank}")
    @NotNull(message = "Email" + "{not.null}")
    private String email;

    @NotBlank(message ="Senha" + "{not.blank}")
    @NotNull(message = "Senha" + "{not.null}")
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
