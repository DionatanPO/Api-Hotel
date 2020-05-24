package com.example.Api_hotel.service;

import com.example.Api_hotel.model.Manutencao;
import com.example.Api_hotel.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoService {

    @Autowired
    ManutencaoRepository manutencaoRepository;

    public Manutencao salvar(Manutencao manutencao) {
        //validações e etcS
        return manutencaoRepository.save(manutencao);
    }

    public void delete(Manutencao manutencao) {

        manutencaoRepository.delete(manutencao);
    }

    public Manutencao buscaPorID(Long id) throws Exception {
        return manutencaoRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return manutencaoRepository.findAll();
    }


    //buscar todos menos os desativados
    public List buscarEstadoAtivo() {
        String estado = "Desabilitado";
        return manutencaoRepository.findByEstadoNot(estado);
    }
//    
//     //buscar todos por estado
//    public List buscarEstado(String estado) {
//  
//        return manutencaoRepository.findByEstado(estado);
//    }
}
