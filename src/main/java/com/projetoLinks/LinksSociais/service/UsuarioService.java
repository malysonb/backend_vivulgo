package com.projetoLinks.LinksSociais.service;

import javax.transaction.Transactional;

import com.projetoLinks.LinksSociais.dto.UsuarioDTO;
import com.projetoLinks.LinksSociais.model.LinkSocial;
import com.projetoLinks.LinksSociais.model.Usuario;
import com.projetoLinks.LinksSociais.repository.RoleRepository;
import com.projetoLinks.LinksSociais.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    RoleRepository roleRepo;

    @Transactional
    public Usuario cadastrarUsuario(UsuarioDTO dto){
        Usuario usuario = new Usuario(dto);
        if(roleRepo.findById("ROLE_USER").isPresent())
            usuario.setNivelAcesso(roleRepo.findById("ROLE_USER").get());
        LinkSocial lSocial = new LinkSocial();
        return usuarioRepo.save(usuario);
    }

}
