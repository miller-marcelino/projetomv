package com.projetomv.projetomv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetomv.projetomv.model.Cliente;

public interface RepositoryCliente extends JpaRepository <Cliente, Long> {

    
} 