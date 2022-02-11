package com.projetoLinks.LinksSociais.repository;

import com.projetoLinks.LinksSociais.model.Link;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link,Long>{
    
}
