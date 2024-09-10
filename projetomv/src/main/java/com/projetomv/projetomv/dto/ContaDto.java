package com.projetomv.projetomv.dto;

import com.projetomv.projetomv.model.Cliente;

import lombok.Data;

@Data
public class ContaDto {

    private String banco;
    private String numero;
    private String agencia;

    private Cliente cliente;
}
