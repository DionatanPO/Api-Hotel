package com.example.Api_hotel.controller;

import com.example.Api_hotel.model.Apartamento;
import com.example.Api_hotel.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apartamento/")
public class ApartamentoController {

    @Autowired
    ApartamentoService apartamentoService;

    @PostMapping()
    public ResponseEntity<Apartamento> cadastrar(@RequestBody Apartamento ap) {

        Apartamento apartamentoSalvo = apartamentoService.salvar(ap);

        return new ResponseEntity<>(apartamentoSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Apartamento> editar(@RequestBody Apartamento ap) {

        Apartamento apartamentoSalvo = apartamentoService.salvar(ap);

        return ResponseEntity.ok(apartamentoSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Apartamento ap = new Apartamento();
        ap.setId(id);
        apartamentoService.delete(ap);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Apartamento>> mostrarTodos() {

        List apartamentoList = apartamentoService.buscarTodos();

        return new ResponseEntity<>(apartamentoList, HttpStatus.OK);
    }

    @GetMapping(value = "todosDisponivel/{id}")
    public ResponseEntity<List<Apartamento>> mostrarTodosAtivos(@PathVariable Long id) {

        List apartamentoList = apartamentoService.buscarDisponiveis(id);

        return new ResponseEntity<>(apartamentoList, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Apartamento> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(apartamentoService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "identificacao/")
    @ResponseBody
    public ResponseEntity<List<Apartamento>> buscaNome(@RequestParam String identificacao) {
        Apartamento ap = new Apartamento();
        ap.setIdentificacao(identificacao);
        List apartamentoList = apartamentoService.buscarIdentificacao(ap);

        return new ResponseEntity<>(apartamentoList, HttpStatus.OK);
    }

    @GetMapping(value = "todos/{id}")
    @ResponseBody
    public ResponseEntity<List<Apartamento>> buscaEstado(@PathVariable Long id) {

        List apartamentoList = apartamentoService.buscarEstado(id);
        return new ResponseEntity<List<Apartamento>>(apartamentoList, HttpStatus.OK);
    }

}
