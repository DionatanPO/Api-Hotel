package com.example.Api_hotel.controller;


import com.example.Api_hotel.model.Limpeza;
import com.example.Api_hotel.service.LimpezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/limpeza/")
public class LimpezaController {

    @Autowired
    LimpezaService limpezaService;

    @PostMapping()
    public ResponseEntity<Limpeza> cadastrar(@RequestBody Limpeza limpeza) {

        Limpeza limpezaSalvo = limpezaService.salvar(limpeza);

        return new ResponseEntity<>(limpezaSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Limpeza> editar(@RequestBody Limpeza limpeza) {

        Limpeza limpezaSalvo = limpezaService.salvar(limpeza);

        return ResponseEntity.ok(limpezaSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Limpeza limpeza = new Limpeza();
        limpeza.setId(id);
        limpezaService.delete(limpeza);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Limpeza>> mostrarTodos() {

        List limpezaList = limpezaService.buscarTodos();

        return new ResponseEntity<List<Limpeza>>(limpezaList, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Limpeza> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(limpezaService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
   
 

}
