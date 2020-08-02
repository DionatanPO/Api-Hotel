package com.example.Api_hotel.controller;

import com.example.Api_hotel.model.Hotel;
import com.example.Api_hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hotel/")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping()
    public ResponseEntity<Hotel> cadastrar(@RequestBody Hotel hotel) {

        Hotel hotelSalvo = hotelService.salvar(hotel);

        return new ResponseEntity<>(hotelSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Hotel> editar(@RequestBody Hotel hotel) {

        Hotel hotelSalvo = hotelService.salvar(hotel);

        return ResponseEntity.ok(hotelSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotelService.delete(hotel);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Hotel>> mostrarTodos() {

        List hotelList = hotelService.buscarTodos();

        return new ResponseEntity<>(hotelList, HttpStatus.OK);
    }

//    @GetMapping(value = "todosAtivos/{id}")
//    public ResponseEntity<List<Hotel>> mostrarTodosAtivos(@PathVariable Long id) {
//
//        List hotelList = hotelService.buscarEstadoAtivo(id);
//
//        return new ResponseEntity<>(hotelList, HttpStatus.OK);
//    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Hotel> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(hotelService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
