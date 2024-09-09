package com.projetomv.projetomv.dto;

import com.projetomv.projetomv.model.Cliente;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ContaDto {

    private String banco;
    private String numero;
    private String agencia;

    @Enumerated(EnumType.STRING)
    private Cliente cliente;
}
