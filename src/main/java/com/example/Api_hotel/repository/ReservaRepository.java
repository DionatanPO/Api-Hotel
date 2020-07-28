package com.example.Api_hotel.repository;


import com.example.Api_hotel.model.Reserva;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * from Reserva where funcionario_id=?1 and estado !='Desabilitado'", nativeQuery = true)
    List<Reserva> buscarReservas(Long i);

}
