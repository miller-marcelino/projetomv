package com.projetomv.projetomv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetomv.projetomv.model.Conta;

public interface RepositoryConta extends JpaRepository <Conta, Long>
 {

    
}
