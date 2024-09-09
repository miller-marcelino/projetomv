package com.projetomv.projetomv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetomv.projetomv.model.Movimentacao;

public interface RepositoryMovimentacao extends JpaRepository <Movimentacao, Long> {

    
}
