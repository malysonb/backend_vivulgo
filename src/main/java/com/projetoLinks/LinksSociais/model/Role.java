package com.projetoLinks.LinksSociais.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority{

    @Id
    @Column(unique = true)
    private String nivel;

    @OneToMany(mappedBy = "nivelAcesso", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    public Role() {
    }

    public Role(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String getAuthority() {
        return this.nivel;
    }
    
}
