package com.projetoLinks.LinksSociais.controller;

import javax.validation.Valid;

import com.projetoLinks.LinksSociais.config.JwtTokenUtil;
import com.projetoLinks.LinksSociais.dto.LoginDTO;
import com.projetoLinks.LinksSociais.dto.TokenResposta;
import com.projetoLinks.LinksSociais.dto.UsuarioDTO;
import com.projetoLinks.LinksSociais.model.Usuario;
import com.projetoLinks.LinksSociais.service.LoginService;
import com.projetoLinks.LinksSociais.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Qualifier("authenticationManagerBean")
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    LoginService loginService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<String> teste(){
        return ResponseEntity.ok("FUNCIONA!");
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResposta> login(@Valid @RequestBody LoginDTO dto) throws Exception {
        autenticar(dto);
        final UserDetails userDetails = loginService.loadUserByUsername(dto.getLogin());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new TokenResposta(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> signUp(@Valid @RequestBody UsuarioDTO dto) {
        return new ResponseEntity<>(usuarioService.cadastrarUsuario(dto), HttpStatus.OK);
    }

    private void autenticar(LoginDTO dto) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha()));
        } catch (Exception e) {
            throw new Exception("Usuario não existe!");
        }
    }

}
