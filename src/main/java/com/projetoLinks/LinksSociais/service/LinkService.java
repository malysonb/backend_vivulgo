package com.projetoLinks.LinksSociais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoLinks.LinksSociais.dto.LinkDTO;
import com.projetoLinks.LinksSociais.model.Link;
import com.projetoLinks.LinksSociais.model.LinkSocial;
import com.projetoLinks.LinksSociais.model.Usuario;
import com.projetoLinks.LinksSociais.repository.LinkRepository;
import com.projetoLinks.LinksSociais.repository.LinkSocialRepository;

@Service
public class LinkService {
    
    @Autowired
    LinkRepository linkRepo;

    @Autowired
    LinkSocialRepository linkSocialRepo;

    @Autowired
    UsuarioService uService;

    public LinkSocial addLink(LinkDTO dto) throws Exception{
        Usuario user = uService.getUsuarioLogado();
        Link link = new Link(dto, user.getLinkSocial());
        LinkSocial ref = user.getLinkSocial();
        ref.addLink(link);
        return linkSocialRepo.save(ref);
    }

}
