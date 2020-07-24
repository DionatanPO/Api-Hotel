package com.example.Api_hotel.controller;

import com.example.Api_hotel.model.Apartamento;
import com.example.Api_hotel.model.Limpeza;
import com.example.Api_hotel.service.LimpezaService;
import java.text.ParseException;
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
        limpeza.setL_id(id);
        limpezaService.delete(limpeza);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Limpeza> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(limpezaService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "todos/{id}")
    @ResponseBody
    public ResponseEntity<List<Apartamento>> buscaEstado(@PathVariable Long id) {

        List apartamentoList = limpezaService.buscarTodos(id);
        return new ResponseEntity<List<Apartamento>>(apartamentoList, HttpStatus.OK);
    }

    @GetMapping(value = "todosData/{id}/{data}")
    @ResponseBody
    public ResponseEntity<List<Limpeza>> buscaLimpezasPorData(@PathVariable Long id, @PathVariable String data) throws ParseException {

        List limpezaList = limpezaService.buscarTodosDia(id,data);
        return new ResponseEntity<List<Limpeza>>(limpezaList, HttpStatus.OK);
    }
}
