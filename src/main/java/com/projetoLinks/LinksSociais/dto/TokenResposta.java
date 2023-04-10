package com.projetoLinks.LinksSociais.dto;

import java.util.Date;

public class TokenResposta {
    
    private final String token;

    private final Date expiration;

    public TokenResposta(String token, Date expiration) {
        this.token = token;
        this.expiration = expiration;
    }

    public String getToken() {
        return token;
    }

    public Date getExpiration() {
        return expiration;
    }

}
