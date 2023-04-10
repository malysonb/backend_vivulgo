package com.projetoLinks.LinksSociais.service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import com.projetoLinks.LinksSociais.config.JwtTokenUtil;
import com.projetoLinks.LinksSociais.dto.UsuarioDTO;
import com.projetoLinks.LinksSociais.model.LinkSocial;
import com.projetoLinks.LinksSociais.model.Usuario;
import com.projetoLinks.LinksSociais.repository.RoleRepository;
import com.projetoLinks.LinksSociais.repository.UsuarioRepository;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    private HttpServletRequest context;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Transactional
    public Usuario cadastrarUsuario(UsuarioDTO dto){
        Usuario usuario = new Usuario(dto);
        if(roleRepo.findById("ROLE_USER").isPresent())
            usuario.setNivelAcesso(roleRepo.findById("ROLE_USER").get());
        LinkSocial lSocial = new LinkSocial(usuario);
        usuario.setLinkSocial(lSocial);
        return usuarioRepo.save(usuario);
    }

    @Transactional
    public Usuario getUsuarioLogado() throws Exception{
        try {
            String header = context.getHeader("Authorization");
            header = header.substring(7); //Bearer 
            Usuario usuario = usuarioRepo.findByLogin(jwtTokenUtil.getUsernameFromToken(header))
            .orElseThrow(() -> new Exception("Usuario não encontrado!"));
            if(usuario.getLinkSocial() != null && usuario.getLinkSocial().getLinks() != null)
                Hibernate.initialize(usuario.getLinkSocial().getLinks());
            return usuario;    
        } catch (Exception e) {
            return null;
        }
    }

}
