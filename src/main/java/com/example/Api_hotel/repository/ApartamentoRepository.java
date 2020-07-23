package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Apartamento;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

    List<Apartamento> findByIdentificacaoContaining(String identifica);

    List<Apartamento> findByEstadoNot(String estado);

    List<Apartamento> findByEstado(String estado);

    @Modifying
    @Transactional
    @Query(value = "SELECT * from Apartamento where funcionario_id=?1 and estado !='Desabilitado'", nativeQuery = true)
    List<Apartamento> buscarApartamentos(Long i);

    @Modifying
    @Transactional
    @Query(value = "SELECT * from Apartamento WHERE funcionario_id =?1 AND estado='Sujo'", nativeQuery = true)
    List<Apartamento> buscarApartamentosSujo(Long i);

}
