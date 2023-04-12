package com.projetoLinks.LinksSociais.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetoLinks.LinksSociais.dto.LinkDTO;

@Entity
@Table(name = "link")
public class Link {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @Column(name = "id_link")
    private long idLink;

    @ManyToOne
    @JoinColumn(name = "linkSocial_id", nullable = false)
    @JsonIgnore
    private LinkSocial pagina;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "modelo")
    private String modelo;
 
    @Column(name = "cor_texto")
    private String corTexto;

    @Column(name = "cor_icone")
    private String corIcone;

    @Column(name = "cor_borda")
    private String corBorda;

    @Column(name = "cor_fundo")
    private String corFundo;

    //////////////////////

    public Link() {
    }

    public Link(LinkDTO dto, LinkSocial pagina) {
        this.pagina = pagina;
        this.nome = dto.getNome();
        this.link = dto.getLink();
        this.modelo = dto.getModelo();
        this.corBorda = dto.getCorBorda();
        this.corFundo = dto.getCorFundo();
        this.corIcone = dto.getCorIcone();
        this.corTexto = dto.getCorTexto();
    }

    public void editar(LinkDTO dto) {
        this.nome = dto.getNome();
        this.link = dto.getLink();
        this.modelo = dto.getModelo();
        this.corBorda = dto.getCorBorda();
        this.corFundo = dto.getCorFundo();
        this.corIcone = dto.getCorIcone();
        this.corTexto = dto.getCorTexto();
    }

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

    public String getCorTexto() {
        return corTexto;
    }

    public void setCorTexto(String corTexto) {
        this.corTexto = corTexto;
    }

    public String getCorIcone() {
        return corIcone;
    }

    public void setCorIcone(String corIcone) {
        this.corIcone = corIcone;
    }

    public String getCorBorda() {
        return corBorda;
    }

    public void setCorBorda(String corBorda) {
        this.corBorda = corBorda;
    }

    public String getCorFundo() {
        return corFundo;
    }

    public void setCorFundo(String corFundo) {
        this.corFundo = corFundo;
    }

    
}
