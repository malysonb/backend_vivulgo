package com.projetoLinks.LinksSociais.dto;

import java.util.Date;

import com.projetoLinks.LinksSociais.model.LinkSocial;
import com.projetoLinks.LinksSociais.model.Usuario;

public class UsuarioViewDTO {

    private String login;

    private String nome;

    private String email;

    private String nivelAcesso;

    private LinkSocial pagina;

    public UsuarioViewDTO() {
    }

    public UsuarioViewDTO(Usuario usuario) {
        this.login = usuario.getLogin();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.nivelAcesso = usuario.getNivelAcesso().getAuthority();
        this.pagina = usuario.getLinkSocial();
    }

    public UsuarioViewDTO(Usuario usuario, Date expiration) {
        this.login = usuario.getLogin();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.nivelAcesso = usuario.getNivelAcesso().getAuthority();
        this.pagina = usuario.getLinkSocial();
    }

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

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public LinkSocial getPagina() {
        return pagina;
    }

    public void setPagina(LinkSocial linkSocial) {
        this.pagina = linkSocial;
    }

}
