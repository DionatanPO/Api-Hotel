package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Limpeza;
import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LimpezaRepository extends JpaRepository<Limpeza, Long> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * from Limpeza INNER JOIN Funcionario ON Funcionario.administrador_id=:i "
            + "AND Limpeza.funcionario_id = Funcionario.id AND limpeza.data_limpeza=:data"
            + " INNER JOIN Apartamento ON Apartamento.estado !='Desabilitado' AND apartamento.id= limpeza.apartamento_id", nativeQuery = true)
    List<Limpeza> buscarLimpezas(@Param("i") Long i, @Param("data") Date data);
    
}
