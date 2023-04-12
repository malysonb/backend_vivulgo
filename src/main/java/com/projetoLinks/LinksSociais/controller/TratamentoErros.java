package com.projetoLinks.LinksSociais.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoLinks.LinksSociais.dto.ErrorDTO;

@RestController
public class TratamentoErros implements ErrorController{
    
    @GetMapping(value = "/error")
    public ResponseEntity<ErrorDTO> error(HttpServletRequest request) {
        String ex = (String)request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        return new ResponseEntity<>(new ErrorDTO(ex), HttpStatus.UNAUTHORIZED);
    }

}
