package com.projetomv.projetomv.model;

import java.time.LocalDate;

import com.projetomv.projetomv.Enum.TipoCliente;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco; // Relacionamento com a tabela Endereços
    private String telefone;
    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente; // Enum para diferenciar entre PJ e PF

}
