package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Hospedagem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {

//    List<Hospedagem> findByIdentificacaoContaining(String identifica);
    List<Hospedagem> findByEstadoNot(String estado);
//   List<Hospedagem> findByEstado(String estado);

}
