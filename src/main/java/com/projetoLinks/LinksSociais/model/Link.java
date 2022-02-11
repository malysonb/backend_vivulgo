package com.projetoLinks.LinksSociais.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "link")
public class Link {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @Column(name = "id_link")
    private long idLink;

    @ManyToOne
    @JoinColumn(name = "linkSocial_id", nullable = false)
    private LinkSocial pagina;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "modelo")
    private String modelo;


    //////////////////////

    public long getIdLink() {
        return idLink;
    }

    public void setIdLink(long idLink) {
        this.idLink = idLink;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LinkSocial getPagina() {
        return pagina;
    }

    public void setPagina(LinkSocial pagina) {
        this.pagina = pagina;
    }

    
}
