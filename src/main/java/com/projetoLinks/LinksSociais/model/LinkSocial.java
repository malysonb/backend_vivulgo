package com.projetoLinks.LinksSociais.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "linkSocial")
public class LinkSocial implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private long idLinkSocial;

    @OneToOne(mappedBy = "linkSocial")
    private Usuario donoUsuario;

    @Lob
    @Column(name = "imagem" )
    private byte[] imagem;

    @Lob
    @Column(name = "imagem_background")
    private byte[] imagemBackground;

    @OneToMany(mappedBy = "pagina", cascade = CascadeType.ALL)
    private List<Link> links;

    public Usuario getDonoUsuario() {
        return donoUsuario;
    }

    public void setDonoUsuario(Usuario donoUsuario) {
        this.donoUsuario = donoUsuario;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public byte[] getImagemBackground() {
        return imagemBackground;
    }

    public void setImagemBackground(byte[] imagemBackground) {
        this.imagemBackground = imagemBackground;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public long getIdLinkSocial() {
        return idLinkSocial;
    }

    public void setIdLinkSocial(long idLinkSocial) {
        this.idLinkSocial = idLinkSocial;
    }

    
}
