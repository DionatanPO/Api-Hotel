package com.example.Api_hotel.controller;

import com.example.Api_hotel.model.Reserva;
import com.example.Api_hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reserva/")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @PostMapping()
    public ResponseEntity<Reserva> cadastrar(@RequestBody Reserva reserva) {

        Reserva reservaSalvo = reservaService.salvar(reserva);

        return new ResponseEntity<>(reservaSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Reserva> editar(@RequestBody Reserva reserva) {

        Reserva reservaSalvo = reservaService.salvar(reserva);

        return ResponseEntity.ok(reservaSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Reserva reserva = new Reserva();
        reserva.setId(id);
        reservaService.delete(reserva);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Reserva>> mostrarTodos() {

        List reservaList = reservaService.buscarTodos();

        return new ResponseEntity<>(reservaList, HttpStatus.OK);
    }

    @GetMapping(value = "todosAtivos")
    public ResponseEntity<List<Reserva>> mostrarTodosAtivos() {

        List reservaList = reservaService.buscarEstadoAtivo();

        return new ResponseEntity<>(reservaList, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Reserva> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(reservaService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping(value = "identificacao/")
//    @ResponseBody
//    public ResponseEntity<List<Reserva>> buscaNome(@RequestParam String identificacao) {
//        Reserva reserva = new Reserva();
//        reserva.setIdentificacao(identificacao);
//        List reservaList = reservaService.buscarIdentificacao(reserva);
//
//        return new ResponseEntity<>(reservaList, HttpStatus.OK);
//    }
    
//        @GetMapping(value = "estado/")
//    @ResponseBody
//    public ResponseEntity<List<Reserva>> buscaEstado(@RequestParam String estado) {
//        Reserva reserva = new Reserva();
//        reserva.setEstado(estado);
//        List reservaList = reservaService.buscarEstado(reserva.getEstado());
//
//        return new ResponseEntity<>(reservaList, HttpStatus.OK);
//    }

}
