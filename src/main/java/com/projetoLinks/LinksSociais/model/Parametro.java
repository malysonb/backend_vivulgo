package com.projetoLinks.LinksSociais.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "parametro")
public class Parametro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @Column(name = "id_parametro")
    @JsonIgnore
    private long idParametro;

    @Column(name = "nome", nullable = true, unique = true)
    private String nome;

    @Column(name = "valor", nullable = true)
    private String valor;

    public Parametro() {
    }

    public Parametro(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public long getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(long idParametro) {
        this.idParametro = idParametro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    

}
