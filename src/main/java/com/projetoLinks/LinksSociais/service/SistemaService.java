package com.projetoLinks.LinksSociais.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoLinks.LinksSociais.dto.StatusServerDTO;
import com.projetoLinks.LinksSociais.model.Parametro;
import com.projetoLinks.LinksSociais.repository.ParametroRepository;

@Service
public class SistemaService {
    
    @Autowired
    ParametroRepository paramRepo;

    public StatusServerDTO getStatus(){
        return new StatusServerDTO(
            paramRepo.findByNome("VERSAO").getValor(),
            paramRepo.findByNome("SERVIDOR").getValor(),
            paramRepo.findByNome("LICENCA").getValor(),
            paramRepo.findByNome("CORS").getValor(),
            paramRepo.findByNome("PERFIL").getValor()
        );
    }

    public List<Parametro> listParametros(){
        return paramRepo.findAll();
    }

}
