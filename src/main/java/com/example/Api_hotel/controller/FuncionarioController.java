package com.example.Api_hotel.controller;

import com.example.Api_hotel.model.Funcionario;
import com.example.Api_hotel.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario/")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping()
    public ResponseEntity<Funcionario> cadastrar(@RequestBody Funcionario fum) {

        Funcionario funcionarioSalvo = funcionarioService.salvar(fum);

        return new ResponseEntity<>(funcionarioSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Funcionario> editar(@RequestBody Funcionario fum) {

        Funcionario funcionarioSalvo = funcionarioService.salvar(fum);

        return ResponseEntity.ok(funcionarioSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Funcionario fum = new Funcionario();
        fum.setId(id);
        funcionarioService.delete(fum);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Funcionario>> mostrarTodos() {

        List funcionarioList = funcionarioService.buscarTodos();

        return new ResponseEntity<>(funcionarioList, HttpStatus.OK);
    }
      @GetMapping(value = "todosAtivos")
    public ResponseEntity<List<Funcionario>> mostrarTodosAtivos() {

        List apartamentoList = funcionarioService.buscarEstadoAtivo();

        return new ResponseEntity<>(apartamentoList, HttpStatus.OK);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Funcionario> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(funcionarioService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "nome/")
    @ResponseBody
    public ResponseEntity<List<Funcionario>> buscaNome(@RequestParam String nome) {
        Funcionario fum = new Funcionario();
        fum.setNome(nome);
        List funcionarioList = funcionarioService.buscarNome(fum);

        return new ResponseEntity<>(funcionarioList, HttpStatus.OK);
    }

}
