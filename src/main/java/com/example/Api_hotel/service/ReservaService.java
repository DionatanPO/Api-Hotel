package com.example.Api_hotel.service;

import com.example.Api_hotel.model.Reserva;
import com.example.Api_hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    public Reserva salvar(Reserva reserva) {
        //validações e etcS
        return reservaRepository.save(reserva);
    }

    public void delete(Reserva reserva) {

        reservaRepository.delete(reserva);
    }

    public Reserva buscaPorID(Long id) throws Exception {
        return reservaRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return reservaRepository.findAll();
    }


    //buscar todos menos os desativados
    public List buscarEstadoAtivo() {
        String estado = "Desabilitado";
        return reservaRepository.findByEstadoNot(estado);
    }
//    
//     //buscar todos por estado
//    public List buscarEstado(String estado) {
//  
//        return reservaRepository.findByEstado(estado);
//    }
}
