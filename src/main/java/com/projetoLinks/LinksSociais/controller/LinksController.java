package com.projetoLinks.LinksSociais.controller;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoLinks.LinksSociais.dto.LinkDTO;
import com.projetoLinks.LinksSociais.model.LinkSocial;
import com.projetoLinks.LinksSociais.repository.LinkSocialRepository;
import com.projetoLinks.LinksSociais.service.LinkService;
import com.projetoLinks.LinksSociais.service.UsuarioService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/pagina")
@Api
public class LinksController {
    
    @Autowired
    LinkSocialRepository linkRepo;

    @Autowired
    LinkService linkService;

    @Autowired
    UsuarioService uService;

    @GetMapping("/{id}")
    @PermitAll
    public ResponseEntity<LinkSocial> getPagina(@PathVariable("id") Long id) throws Exception{
        return new ResponseEntity<>(linkRepo.findById(id).orElseThrow(() -> new Exception("Pagina não encontrada")), HttpStatus.OK);
    }

    @GetMapping("/user/{usuario}")
    @PermitAll
    public ResponseEntity<LinkSocial> getPaginaUser(@PathVariable("usuario") String username) throws Exception{
        return new ResponseEntity<>(linkService.getByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LinkSocial> addLink(@Valid @RequestBody LinkDTO dto) throws Exception{
        if(uService.getUsuarioLogado() == null){
            throw new Exception("Não autorizado");
        }
        return new ResponseEntity<>(linkService.addLink(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LinkSocial> putLink(@Valid @RequestBody LinkDTO dto, @PathVariable("id") Long id) throws Exception{
        if(uService.getUsuarioLogado() == null){
            throw new Exception("Não autorizado");
        }
        if(id == null)
            throw new Exception("Campo Id não foi informado!");
        return new ResponseEntity<>(linkService.updateLink(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delLink(@PathVariable("id") Long id) throws Exception{
        if(uService.getUsuarioLogado() == null){
            throw new Exception("Não autorizado");
        }
        if(id == null)
            throw new Exception("Campo Id não foi informado!");
        linkService.deleteLink(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
