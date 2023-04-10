package com.projetoLinks.LinksSociais.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LinkDTO {
    
    @NotBlank(message ="Nome " + "{not.blank}")
    @NotNull(message = "Nome " + "{not.null}")
    private String nome;

    @NotBlank(message ="Link " + "{not.blank}")
    @NotNull(message = "Link " + "{not.null}")
    private String link;

    @NotBlank(message ="Modelo " + "{not.blank}")
    @NotNull(message = "Modelo " + "{not.null}")
    private String modelo;

    @NotBlank(message ="Cor do texto " + "{not.blank}")
    @NotNull(message = "Cor do texto " + "{not.null}")
    private String corTexto;

    @NotBlank(message ="Cor do icone " + "{not.blank}")
    @NotNull(message = "Cor do icone " + "{not.null}")
    private String corIcone;

    @NotBlank(message ="Cor da borda " + "{not.blank}")
    @NotNull(message = "Cor da borda " + "{not.null}")
    private String corBorda;

    @NotBlank(message ="Cor de fundo " + "{not.blank}")
    @NotNull(message = "Cor de fundo " + "{not.null}")
    private String corFundo;

    public LinkDTO() {
    }

    public LinkDTO(@NotBlank(message = "Nome {not.blank}") @NotNull(message = "Nome {not.null}") String nome,
            @NotBlank(message = "Link {not.blank}") @NotNull(message = "Link {not.null}") String link,
            @NotBlank(message = "Modelo {not.blank}") @NotNull(message = "Modelo {not.null}") String modelo,
            @NotBlank(message = "Cor do texto {not.blank}") @NotNull(message = "Cor do texto {not.null}") String corTexto,
            @NotBlank(message = "Cor do icone {not.blank}") @NotNull(message = "Cor do icone {not.null}") String corIcone,
            @NotBlank(message = "Cor da borda {not.blank}") @NotNull(message = "Cor da borda {not.null}") String corBorda,
            @NotBlank(message = "Cor de fundo {not.blank}") @NotNull(message = "Cor de fundo {not.null}") String corFundo) {
        this.nome = nome;
        this.link = link;
        this.modelo = modelo;
        this.corTexto = corTexto;
        this.corIcone = corIcone;
        this.corBorda = corBorda;
        this.corFundo = corFundo;
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
