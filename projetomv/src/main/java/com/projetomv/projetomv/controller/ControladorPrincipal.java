package com.projetomv.projetomv.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetomv.projetomv.dto.ClienteDto;
import com.projetomv.projetomv.model.Cliente;
import com.projetomv.projetomv.repository.RepositoryCliente;
import com.projetomv.projetomv.repository.RepositoryConta;
import com.projetomv.projetomv.repository.RepositoryMovimentacao;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/")
public class ControladorPrincipal {

    @Autowired
    RepositoryCliente repositoryCliente;
    @Autowired
    RepositoryConta repositoryConta;
    @Autowired
    RepositoryMovimentacao repositoryMovimentacao;

    @PostMapping("cadastrar-clientes")
    private ResponseEntity<?> cadastrarclientes(@RequestBody @Valid ClienteDto clienteDto,
            BindingResult bindingResult) {
        try {
            Cliente cliente = new Cliente();
            cliente.setNome(clienteDto.getNome());
            cliente.setDataCadastro(clienteDto.getDataCadastro());
            cliente.setEndereco(clienteDto.getEndereco());
            cliente.setTelefone(clienteDto.getTelefone());
            cliente.setTipoCliente(clienteDto.getTipoCliente());

            cliente = repositoryCliente.save(cliente);

            return new ResponseEntity<>("Cliente Cadastrado com sucesso", HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar clientes" + e.getMessage());
        }

    }

    @GetMapping(value = "listar-clientes/{id_cliente}")
    public ResponseEntity<Cliente> listarClientes(@PathVariable Long id_cliente) {
        Optional<Cliente> cliente = repositoryCliente.findById(id_cliente);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deletar-clientes/(id_cliente)")
    public ResponseEntity<Long> deletarClientes (@PathVariable Long id_clientes) {
        boolean existeClientes = repositoryCliente.existsById(id_clientes);
        if (existeClientes) {
            repositoryCliente.deleteById(id_clientes);
            return new ResponseEntity<>(id_clientes, HttpStatus.OK);
        }
        return new ResponseEntity<>(id_clientes, HttpStatus.NO_CONTENT);
    }

    @PutMapping ("atualizar-clientes/{id_clientes}")
    public ResponseEntity<Cliente> atualizarClientes(@PathVariable Long id_clietes, @RequestBody ClienteDto clienteDto) {
        Optional<Cliente> existingClientes = repositoryCliente.findById(id_clietes);

        if (existingClientes.isPresent()) {

            Cliente clientesExistente = existingClientes.get();
            clientesExistente.setNome(clienteDto.getNome());
            clientesExistente.setEndereco(clienteDto.getEndereco());
            clientesExistente.setDataCadastro(clienteDto.getDataCadastro());
            clientesExistente.setTelefone(clienteDto.getTelefone());
            clientesExistente.setTipoCliente(clienteDto.getTipoCliente());

            Cliente clienteatualizado = repositoryCliente.save(clientesExistente);

            return ResponseEntity.ok(clienteatualizado);     
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
