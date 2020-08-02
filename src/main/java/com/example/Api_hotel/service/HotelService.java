package com.example.Api_hotel.service;

import com.example.Api_hotel.model.Hotel;
import com.example.Api_hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public Hotel salvar(Hotel hotel) {
        //validações e etcS
        return hotelRepository.save(hotel);
    }

    public void delete(Hotel hotel) {

        hotelRepository.delete(hotel);
    }

    public Hotel buscaPorID(Long id) throws Exception {
        return hotelRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return hotelRepository.findAll();
    }


    //buscar todos menos os desativados
    public void buscarEstadoAtivo(Long id) {
//      
//        return hotelRepository.buscarHotels(id);
    }

}
