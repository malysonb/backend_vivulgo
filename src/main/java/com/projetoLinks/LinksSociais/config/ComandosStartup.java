package com.projetoLinks.LinksSociais.config;

import com.projetoLinks.LinksSociais.model.LinkSocial;
import com.projetoLinks.LinksSociais.model.Parametro;
import com.projetoLinks.LinksSociais.model.Role;
import com.projetoLinks.LinksSociais.model.Usuario;
import com.projetoLinks.LinksSociais.repository.ParametroRepository;
import com.projetoLinks.LinksSociais.repository.RoleRepository;
import com.projetoLinks.LinksSociais.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ComandosStartup implements CommandLineRunner{

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    UsuarioRepository userRepo;

    @Autowired
    ParametroRepository paramRepo;

    @Value("${vivulgo.versao}")
    String versao;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        gerarRolesPadrao();
        gerarAdmin();
        gerarParametros();
    }

    private void gerarAdmin() throws Exception{
        if(userRepo.findById(1L).isPresent()){
            System.out.println("EXISTE!");
        }else{
            Usuario user = new Usuario();
            user.setLogin("master");
            user.setNome("admin");
            user.setSenha(new BCryptPasswordEncoder().encode("mudarsenha"));
            user.setEmail("admin@links.com");
            user.setNivelAcesso(roleRepo.findById("ROLE_ADMIN").orElseThrow(() -> new Exception("Role inexistente!")));
            user.setAtivado(true);
            LinkSocial link = new LinkSocial(user);
            user.setLinkSocial(link);
            userRepo.save(user);
        }
    }
   
    private void gerarRolesPadrao(){
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");

        if(!roleRepo.findById("ROLE_USER").isPresent() &&
           !roleRepo.findById("ROLE_ADMIN").isPresent()){
            roleRepo.save(user);
            roleRepo.save(admin);
        }

    }

    private void gerarParametros(){
        if(!paramRepo.findById(1L).isPresent()){
            Parametro p_versao = new Parametro("VERSAO", versao);
            Parametro p_servidor = new Parametro("SERVIDOR", "");
            Parametro p_licenca = new Parametro("LICENCA", "");
            Parametro cors = new Parametro("CORS", "");
            Parametro perfil = new Parametro("PERFIL", "DEV");
    
            paramRepo.save(p_versao);
            paramRepo.save(p_servidor);
            paramRepo.save(p_licenca);
            paramRepo.save(cors);
            paramRepo.save(perfil);
        }
    }

}
