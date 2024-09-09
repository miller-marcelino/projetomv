package com.projetomv.projetomv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "Conta")
public class Conta {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String banco;
    private String numero;
    private String agencia;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
