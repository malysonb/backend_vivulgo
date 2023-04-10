package com.projetoLinks.LinksSociais.repository;

import java.util.Optional;

import com.projetoLinks.LinksSociais.model.Usuario;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    @Query("Select u FROM Usuario u JOIN FETCH u.linkSocial LEFT JOIN FETCH u.linkSocial.links WHERE u.login = (:login)")
    Optional<Usuario> findByLogin(String login);

}
