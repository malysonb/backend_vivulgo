package com.projetoLinks.LinksSociais.service;

import com.projetoLinks.LinksSociais.model.Usuario;
import com.projetoLinks.LinksSociais.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService{

    @Autowired
    UsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepo.findByLogin(username).orElseThrow(
            () -> new UsernameNotFoundException("Usuário não foi encontrado!"));

        return user;
    }
    
}
