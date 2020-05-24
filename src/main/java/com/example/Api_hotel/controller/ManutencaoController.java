package com.example.Api_hotel.controller;

import com.example.Api_hotel.model.Manutencao;
import com.example.Api_hotel.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/manutencao/")
public class ManutencaoController {

    @Autowired
    ManutencaoService manutencaoService;

    @PostMapping()
    public ResponseEntity<Manutencao> cadastrar(@RequestBody Manutencao manutencao) {

        Manutencao manutencaoSalvo = manutencaoService.salvar(manutencao);

        return new ResponseEntity<>(manutencaoSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Manutencao> editar(@RequestBody Manutencao manutencao) {

        Manutencao manutencaoSalvo = manutencaoService.salvar(manutencao);

        return ResponseEntity.ok(manutencaoSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Manutencao manutencao = new Manutencao();
        manutencao.setId(id);
        manutencaoService.delete(manutencao);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Manutencao>> mostrarTodos() {

        List manutencaoList = manutencaoService.buscarTodos();

        return new ResponseEntity<>(manutencaoList, HttpStatus.OK);
    }

    @GetMapping(value = "todosAtivos")
    public ResponseEntity<List<Manutencao>> mostrarTodosAtivos() {

        List manutencaoList = manutencaoService.buscarEstadoAtivo();

        return new ResponseEntity<>(manutencaoList, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Manutencao> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(manutencaoService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping(value = "identificacao/")
//    @ResponseBody
//    public ResponseEntity<List<Manutencao>> buscaNome(@RequestParam String identificacao) {
//        Manutencao manutencao = new Manutencao();
//        manutencao.setIdentificacao(identificacao);
//        List manutencaoList = manutencaoService.buscarIdentificacao(manutencao);
//
//        return new ResponseEntity<>(manutencaoList, HttpStatus.OK);
//    }
    
//        @GetMapping(value = "estado/")
//    @ResponseBody
//    public ResponseEntity<List<Manutencao>> buscaEstado(@RequestParam String estado) {
//        Manutencao manutencao = new Manutencao();
//        manutencao.setEstado(estado);
//        List manutencaoList = manutencaoService.buscarEstado(manutencao.getEstado());
//
//        return new ResponseEntity<>(manutencaoList, HttpStatus.OK);
//    }

}
