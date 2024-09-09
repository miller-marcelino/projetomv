package com.projetomv.projetomv.dto;

import java.time.LocalDate;

import com.projetomv.projetomv.Enum.TipoCliente;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ClienteDto {

    private String nome;
    private String endereco;
    private String telefone;
    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente; // Enum para diferenciar entre PJ e PF

}
