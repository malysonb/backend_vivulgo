package com.projetoLinks.LinksSociais.dto;

public class StatusServerDTO {
    
    private String versao;

    private String servidor;

    private String licenca;

    private String cors;

    private String perfil;

    public StatusServerDTO() {
    }

    public StatusServerDTO(String versao, String servidor, String licenca, String cors, String perfil) {
        this.versao = versao;
        this.servidor = servidor;
        this.licenca = licenca;
        this.cors = cors;
        this.perfil = perfil;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getLicenca() {
        return licenca;
    }

    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }

    public String getCors() {
        return cors;
    }

    public void setCors(String cors) {
        this.cors = cors;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    

}
