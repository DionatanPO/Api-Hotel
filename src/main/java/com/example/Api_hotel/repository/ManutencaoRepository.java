package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Manutencao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

//    List<Manutencao> findByIdentificacaoContaining(String identifica);
    List<Manutencao> findByEstadoNot(String estado);
//   List<Manutencao> findByEstado(String estado);

}
