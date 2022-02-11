package com.projetoLinks.LinksSociais.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.projetoLinks.LinksSociais.dto.UsuarioDTO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @Column(name = "id_user")
    private long idUser;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role nivelAcesso;

    @OneToOne
    @JoinColumn(name = "linkSocial_id")
    private LinkSocial linkSocial;
    

    public Usuario() {
    }

    public Usuario(UsuarioDTO dto) {
        this.login = dto.getLogin();
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.senha = new BCryptPasswordEncoder().encode(dto.getSenha());
    }

    //////////////////////
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(this.nivelAcesso);
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(Role nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public LinkSocial getLinkSocial() {
        return linkSocial;
    }

    public void setLinkSocial(LinkSocial linkSocial) {
        this.linkSocial = linkSocial;
    }
    
}
