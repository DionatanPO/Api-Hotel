package com.example.Api_hotel.service;

import com.example.Api_hotel.model.Apartamento;
import com.example.Api_hotel.model.Limpeza;
import com.example.Api_hotel.repository.ApartamentoRepository;
import com.example.Api_hotel.repository.LimpezaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LimpezaService {

    @Autowired
    LimpezaRepository limpezaRepository;

    @Autowired
    ApartamentoRepository apartamentoRepository;

    public Limpeza salvar(Limpeza limpeza) {
        //validações e etcS
        return limpezaRepository.save(limpeza);
    }

    public void delete(Limpeza limpeza) {

        limpezaRepository.delete(limpeza);
    }

    public Limpeza buscaPorID(Long id) throws Exception {
        return limpezaRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Apartamento> buscarTodos(Long id) {
        return apartamentoRepository.buscarApartamentosSujo(id);
    }

}
