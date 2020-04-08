package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Apartamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

    List<Apartamento> findByIdentificacaoContaining(String identifica);
    List<Apartamento> findByEstadoNot(String estado);
    List<Apartamento> findByEstado(String estado);

}
