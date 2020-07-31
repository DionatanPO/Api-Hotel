package com.example.Api_hotel.controller;

import com.example.Api_hotel.model.Hospedagem;
import com.example.Api_hotel.service.HospedagemService;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hospedagem/")
public class HospedagemController {

    @Autowired
    HospedagemService hospedagemService;

    @PostMapping()
    public ResponseEntity<Hospedagem> cadastrar(@RequestBody Hospedagem hospedagem) {

        Hospedagem hospedagemSalvo = hospedagemService.salvar(hospedagem);

        return new ResponseEntity<>(hospedagemSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Hospedagem> editar(@RequestBody Hospedagem hospedagem) {

        Hospedagem hospedagemSalvo = hospedagemService.salvar(hospedagem);

        return ResponseEntity.ok(hospedagemSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setId(id);
        hospedagemService.delete(hospedagem);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Hospedagem>> mostrarTodos() {

        List hospedagemList = hospedagemService.buscarTodos();

        return new ResponseEntity<>(hospedagemList, HttpStatus.OK);
    }

    @GetMapping(value = "todosAtivos")
    public ResponseEntity<List<Hospedagem>> mostrarTodosAtivos() {

        List hospedagemList = hospedagemService.buscarEstadoAtivo();

        return new ResponseEntity<>(hospedagemList, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Hospedagem> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(hospedagemService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "todas/{gerente_id}")
    @ResponseBody
    public ResponseEntity<List<Hospedagem>> buscaEstado(@PathVariable Long gerente_id) {

        List hospedagemList = hospedagemService.buscarGerente(gerente_id);

        return new ResponseEntity<>(hospedagemList, HttpStatus.OK);
    }

    @GetMapping(value = "todosData/{gerente_id}/{data1}/{data2}")
    @ResponseBody
    public ResponseEntity<List<Hospedagem>> buscaEstado(@PathVariable Long gerente_id, @PathVariable Date data1, @PathVariable Date data2) throws ParseException {

       
        
        List hospedagemList = hospedagemService.buscarEntreDatas(gerente_id, data1.toString(), data2.toString());

        return new ResponseEntity<>(hospedagemList, HttpStatus.OK);
    }
}
