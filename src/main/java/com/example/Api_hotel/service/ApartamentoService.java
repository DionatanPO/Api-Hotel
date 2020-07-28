package com.example.Api_hotel.service;

import com.example.Api_hotel.model.Apartamento;
import com.example.Api_hotel.repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartamentoService {

    @Autowired
    ApartamentoRepository apartamentoRepository;

    public Apartamento salvar(Apartamento apartamento) {
        //validações e etcS
        return apartamentoRepository.save(apartamento);
    }

    public void delete(Apartamento apartamento) {

        apartamentoRepository.delete(apartamento);
    }

    public Apartamento buscaPorID(Long id) throws Exception {
        return apartamentoRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return apartamentoRepository.findAll();
    }

    public List buscarIdentificacao(Apartamento apartamento) {
        return apartamentoRepository.findByIdentificacaoContaining(apartamento.getIdentificacao());
    }

    //buscar todos menos os desativados
    public List buscarDisponiveis(Long id) {
      
        return apartamentoRepository.buscarApartamentosDisponivel(id);
    }
    
     //buscar todos por gerente
    public List buscarEstado(Long id) {
 
        return apartamentoRepository.buscarApartamentos(id);
    }
}
