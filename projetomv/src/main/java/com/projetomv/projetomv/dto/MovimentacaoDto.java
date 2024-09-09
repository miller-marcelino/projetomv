package com.projetomv.projetomv.dto;

import java.time.LocalDate;

import com.projetomv.projetomv.Enum.TipoMovimentacao;
import com.projetomv.projetomv.model.Conta;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.Data;

@Data
public class MovimentacaoDto {

    private LocalDate dataMovimentacao;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    private double valor;
    private Conta conta;
}
