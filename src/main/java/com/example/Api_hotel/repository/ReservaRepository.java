package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Reserva;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

//    List<Reserva> findByIdentificacaoContaining(String identifica);
    List<Reserva> findByEstadoNot(String estado);
//   List<Reserva> findByEstado(String estado);

}
