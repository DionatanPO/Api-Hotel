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
    
     //buscar todos por gerente e abilitadas
    public List buscarGerente(Long gerente_id) {
  
        return hospedagemRepository.buscarHospedagem(gerente_id);
    }
       public List buscarEntreDatas(Long gerente_id, String data1, String data2) {
  
        return hospedagemRepository.buscarHospedagemEntreDatas(gerente_id,data1, data2);
    }
}
