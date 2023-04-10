package com.projetoLinks.LinksSociais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoLinks.LinksSociais.model.Parametro;

public interface ParametroRepository extends JpaRepository<Parametro, Long>{
    
    Parametro findByNome(String nome);

}
