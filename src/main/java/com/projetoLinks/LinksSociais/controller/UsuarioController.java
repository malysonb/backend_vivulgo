package com.projetoLinks.LinksSociais.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.projetoLinks.LinksSociais.config.JwtTokenUtil;
import com.projetoLinks.LinksSociais.model.Usuario;
import com.projetoLinks.LinksSociais.repository.UsuarioRepository;

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
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    private HttpServletRequest context;

    @GetMapping
    public ResponseEntity<Usuario> getUsuarioLogado() throws Exception{
        String header = context.getHeader("Authorization");
        header = header.substring(7); //Bearer 
        Usuario usuario = userRepo.findByLogin(jwtTokenUtil.getUsernameFromToken(header))
                            .orElseThrow(() -> new Exception("Usuario não encontrado!"));
        return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getUsuarios() throws Exception{
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long id){
        userRepo.delete(userRepo.getById(id));
        return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
    }

}
