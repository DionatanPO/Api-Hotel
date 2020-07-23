package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Apartamento;
import com.example.Api_hotel.model.Limpeza;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LimpezaRepository extends JpaRepository<Limpeza, Long> {



//    @Modifying
//    @Transactional
//    @Query(value = "SELECT * from Limpeza INNER JOIN Funcionario ON Funcionario.administrador_id=?1 AND Limpeza.funcionario_id = Funcionario.id", nativeQuery = true)
//    List<Limpeza> buscarLimpezas(Long i);
}
