package com.projetoLinks.LinksSociais.dto;

import java.util.List;

import org.springframework.validation.FieldError;

public class ErrorDTO {
    
    private String erro;

    public ErrorDTO(String erro) {
        this.erro = erro;
    }

    public ErrorDTO(List<FieldError> errors){
        for (FieldError fieldError : errors) {
            erro += fieldError.getDefaultMessage() + ", ";
        }
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    
}
