package com.projetomv.projetomv.model;

import java.time.LocalDate;

import com.projetomv.projetomv.Enum.TipoMovimentacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo", unique = true, nullable = false)
    private Long id;

    private LocalDate dataMovimentacao;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    private double valor; // Valor da movimentação

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

}
