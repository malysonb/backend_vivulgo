package com.projetoLinks.LinksSociais.controller;

import java.util.Date;

import javax.validation.Valid;

import com.projetoLinks.LinksSociais.config.JwtTokenUtil;
import com.projetoLinks.LinksSociais.dto.LoginDTO;
import com.projetoLinks.LinksSociais.dto.StatusServerDTO;
import com.projetoLinks.LinksSociais.dto.TokenResposta;
import com.projetoLinks.LinksSociais.dto.UsuarioDTO;
import com.projetoLinks.LinksSociais.dto.UsuarioViewDTO;
import com.projetoLinks.LinksSociais.service.LoginService;
import com.projetoLinks.LinksSociais.service.SistemaService;
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

    @Autowired
    SistemaService sistemaService;

    @GetMapping
    public ResponseEntity<StatusServerDTO> Status(){
        return new ResponseEntity<>(sistemaService.getStatus(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResposta> login(@Valid @RequestBody LoginDTO dto) throws Exception {
        System.out.println("Recebido");
        autenticar(dto);
        final UserDetails userDetails = loginService.loadUserByUsername(dto.getLogin());
        final String token = jwtTokenUtil.generateToken(userDetails);
        Date expiration = jwtTokenUtil.getExpirationDateFromToken(token);
        return ResponseEntity.ok(new TokenResposta(token, expiration));
    }

    @PostMapping("/signup")
    public ResponseEntity<UsuarioViewDTO> signUp(@Valid @RequestBody UsuarioDTO dto) {
        return new ResponseEntity<>(new UsuarioViewDTO(usuarioService.cadastrarUsuario(dto)), HttpStatus.OK);
    }

    private void autenticar(LoginDTO dto) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha()));
        } catch (Exception e) {
            throw new Exception("Usuário ou senha está incorreto!");
        }
    }

}
