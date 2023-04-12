package com.projetoLinks.LinksSociais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoLinks.LinksSociais.dto.LinkDTO;
import com.projetoLinks.LinksSociais.model.Link;
import com.projetoLinks.LinksSociais.model.LinkSocial;
import com.projetoLinks.LinksSociais.model.Usuario;
import com.projetoLinks.LinksSociais.repository.LinkRepository;
import com.projetoLinks.LinksSociais.repository.LinkSocialRepository;
import com.projetoLinks.LinksSociais.repository.UsuarioRepository;

@Service
public class LinkService {
    
    @Autowired
    LinkRepository linkRepo;

    @Autowired
    LinkSocialRepository linkSocialRepo;

    @Autowired
    UsuarioService uService;

    @Autowired
    UsuarioRepository uRepo;

    public LinkSocial addLink(LinkDTO dto) throws Exception{
        Usuario user = uService.getUsuarioLogado();
        Link link = new Link(dto, user.getLinkSocial());
        LinkSocial ref = user.getLinkSocial();
        ref.addLink(link);
        return linkSocialRepo.save(ref);
    }

    public LinkSocial updateLink(LinkDTO dto, Long id) throws Exception{
        Usuario user = uService.getUsuarioLogado();
        Link link = linkRepo.findById(id).orElseThrow(() -> new Exception("Link não encontrado!"));
        if(!validar(user, link))
            throw new Exception("Acesso negado!");
        link.editar(dto);
        LinkSocial ref = link.getPagina();
        linkRepo.save(link);
        return ref;
    }

    public void deleteLink(Long id) throws Exception{
        Usuario user = uService.getUsuarioLogado();
        Link link = linkRepo.findById(id).orElseThrow(() -> new Exception("Link não encontrado!"));
        if(!validar(user, link))
            throw new Exception("Acesso negado!");
        linkRepo.delete(link);
    }

    public LinkSocial getByUsername(String username) throws Exception{
        Usuario user = uRepo.findByLogin(username).orElseThrow(() -> new Exception("Usuário não encontrado!"));
        return user.getLinkSocial();
    }

    public boolean validar(Usuario user, Link link){
        if(link.getPagina().getIdLinkSocial() == user.getLinkSocial().getIdLinkSocial() || user.getNivelAcesso().getAuthority().equals("ROLE_ADMIN"))
            return true;
        else
            return false;
    }

}
