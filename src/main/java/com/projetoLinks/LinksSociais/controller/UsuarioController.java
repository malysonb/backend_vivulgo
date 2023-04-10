package com.projetoLinks.LinksSociais.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;

import com.projetoLinks.LinksSociais.dto.UsuarioViewDTO;
import com.projetoLinks.LinksSociais.model.Usuario;
import com.projetoLinks.LinksSociais.repository.UsuarioRepository;
import com.projetoLinks.LinksSociais.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController {
    
    @Autowired
    UsuarioRepository userRepo;

    @Autowired
    UsuarioService uService;

    @GetMapping
    @Transactional
    public ResponseEntity<UsuarioViewDTO> getUsuarioLogado() throws Exception{
        Usuario usuario = uService.getUsuarioLogado();
        return new ResponseEntity<>(new UsuarioViewDTO(usuario), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<List<UsuarioViewDTO>> getUsuarios() throws Exception{
        List<UsuarioViewDTO> usuarios = new ArrayList<>();
        for (Usuario user : userRepo.findAll()) {
            usuarios.add(new UsuarioViewDTO(user));
        }
        return new ResponseEntity<>(usuarios, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long id){
        userRepo.delete(userRepo.getById(id));
        return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
    }

}
