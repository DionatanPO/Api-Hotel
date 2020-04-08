package com.example.Api_hotel.service;

import com.example.Api_hotel.model.Hospedagem;
import com.example.Api_hotel.repository.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedagemService {

    @Autowired
    HospedagemRepository hospedagemRepository;

    public Hospedagem salvar(Hospedagem hospedagem) {
        //validações e etcS
        return hospedagemRepository.save(hospedagem);
    }

    public void delete(Hospedagem hospedagem) {

        hospedagemRepository.delete(hospedagem);
    }

    public Hospedagem buscaPorID(Long id) throws Exception {
        return hospedagemRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return hospedagemRepository.findAll();
    }

 

    //buscar todos menos os desativados
    public List buscarEstadoAtivo() {
        String estado = "Desabilitado";
        return hospedagemRepository.findByEstadoNot(estado);
    }
//    
//     //buscar todos por estado
//    public List buscarEstado(String estado) {
//  
//        return hospedagemRepository.findByEstado(estado);
//    }
}
