package com.projetoLinks.LinksSociais.repository;

import java.util.Optional;

import com.projetoLinks.LinksSociais.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    Optional<Usuario> findByLogin(String login);

}
