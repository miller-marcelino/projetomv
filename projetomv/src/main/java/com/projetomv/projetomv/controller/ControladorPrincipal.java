package com.projetomv.projetomv.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetomv.projetomv.dto.ClienteDto;
import com.projetomv.projetomv.dto.ContaDto;
import com.projetomv.projetomv.dto.MovimentacaoDto;
import com.projetomv.projetomv.model.Cliente;
import com.projetomv.projetomv.model.Conta;
import com.projetomv.projetomv.model.Movimentacao;
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

    // EndPoints Relacionados à Clientes.
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
    public ResponseEntity<Long> deletarClientes(@PathVariable Long id_clientes) {
        boolean existeClientes = repositoryCliente.existsById(id_clientes);
        if (existeClientes) {
            repositoryCliente.deleteById(id_clientes);
            return new ResponseEntity<>(id_clientes, HttpStatus.OK);
        }
        return new ResponseEntity<>(id_clientes, HttpStatus.NO_CONTENT);
    }

    @PutMapping("atualizar-clientes/{id_cliente}")
    public ResponseEntity<Cliente> atualizarClientes(@PathVariable Long id_cliete,
            @RequestBody ClienteDto clienteDto) {
        Optional<Cliente> existingCliente = repositoryCliente.findById(id_cliete);

        if (existingCliente.isPresent()) {

            Cliente clientesExistente = existingCliente.get();
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

    // EndPoints Relacionados à Contas.
    @PostMapping("cadastrar-contas")
    private ResponseEntity<?> cadastrarcontas(@RequestBody @Valid ContaDto contaDto,
            BindingResult bindingResult) {
        try {
            Conta conta = new Conta();

            conta.setBanco(contaDto.getBanco());
            conta.setAgencia(contaDto.getAgencia());
            conta.setNumero(contaDto.getNumero());
            conta.setCliente(contaDto.getCliente());

            conta = repositoryConta.save(conta);

            return new ResponseEntity<>("Conta Cadastrada com sucesso", HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar conta" + e.getMessage());
        }

    }

    @GetMapping(value = "listar-contas/{id_conta}")
    public ResponseEntity<Conta> listarContas(@PathVariable Long id_conta) {
        Optional<Conta> conta = repositoryConta.findById(id_conta);

        if (conta.isPresent()) {
            return ResponseEntity.ok(conta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deletar-contas/(id_contas)")
    public ResponseEntity<Long> deletarContas(@PathVariable Long id_contas) {
        boolean existeContas = repositoryConta.existsById(id_contas);
        if (existeContas) {
            repositoryConta.deleteById(id_contas);
            return new ResponseEntity<>(id_contas, HttpStatus.OK);
        }
        return new ResponseEntity<>(id_contas, HttpStatus.NO_CONTENT);
    }

    @PutMapping("atualizar-contas/{id_contas}")
    public ResponseEntity<Conta> atualizarContas(@PathVariable Long id_contas,
            @RequestBody ContaDto contaDto) {
        Optional<Conta> existingConta = repositoryConta.findById(id_contas);

        if (existingConta.isPresent()) {

            Conta contasExistente = existingConta.get();

            contasExistente.setBanco(contaDto.getBanco());
            contasExistente.setAgencia(contaDto.getAgencia());
            contasExistente.setNumero(contaDto.getNumero());

            Conta contaAtualizada = repositoryConta.save(contasExistente);

            return ResponseEntity.ok(contaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // EndPoints Relacionados à Movimentações.
    @PostMapping("cadastrar-movimentacoes")
    private ResponseEntity<?> cadastrarmovimentacoes(@RequestBody @Valid MovimentacaoDto movimentacaoDtoDto,
            BindingResult bindingResult) {
        try {
            Movimentacao movimentacao = new Movimentacao();

            movimentacao.setTipo(movimentacaoDtoDto.getTipo());
            movimentacao.setDataMovimentacao(movimentacaoDtoDto.getDataMovimentacao());
            movimentacao.setConta(movimentacaoDtoDto.getConta());
            movimentacao.setValor(movimentacaoDtoDto.getValor());

            movimentacao = repositoryMovimentacao.save(movimentacao);

            return new ResponseEntity<>("Movimentação Cadastrada com sucesso", HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar movimentação" + e.getMessage());
        }

    }

    @GetMapping(value = "listar-movimentacao/{id_movimentacao}")
    public ResponseEntity<Movimentacao> listarMovimentacao(@PathVariable Long id_movimentacao) {
        Optional<Movimentacao> movimentacao = repositoryMovimentacao.findById(id_movimentacao);

        if (movimentacao.isPresent()) {
            return ResponseEntity.ok(movimentacao.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deletar-movimentacao/(id_movimentacao)")
    public ResponseEntity<Long> deletarMovimentacao(@PathVariable Long id_movimentacao) {
        boolean existeMovimentacao = repositoryMovimentacao.existsById(id_movimentacao);
        if (existeMovimentacao) {
            repositoryMovimentacao.deleteById(id_movimentacao);
            return new ResponseEntity<>(id_movimentacao, HttpStatus.OK);
        }
        return new ResponseEntity<>(id_movimentacao, HttpStatus.NO_CONTENT);
    }

    @PutMapping("atualizar-movimentacao/{id_movimentacao}")
    public ResponseEntity<Movimentacao> atualizarMovimentacao(@PathVariable Long id_movimentacao,
            @RequestBody MovimentacaoDto movimentacaoDto) {
        Optional<Movimentacao> existingMovimentacao = repositoryMovimentacao.findById(id_movimentacao);

        if (existingMovimentacao.isPresent()) {

            Movimentacao movimentacaoExistente = existingMovimentacao.get();

            movimentacaoExistente.setDataMovimentacao(movimentacaoDto.getDataMovimentacao());
            movimentacaoExistente.setValor(movimentacaoDto.getValor());
            movimentacaoExistente.setTipo(movimentacaoDto.getTipo());
            movimentacaoExistente.setConta(movimentacaoDto.getConta());

            Movimentacao movimentacaoatualizada = repositoryMovimentacao.save(movimentacaoExistente);

            return ResponseEntity.ok(movimentacaoatualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
