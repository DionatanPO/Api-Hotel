package com.example.Api_hotel.repository;


import com.example.Api_hotel.model.Manutencao;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * from Manutencao INNER JOIN Funcionario ON  Funcionario.administrador_id=?1 AND Manutencao.estado!='Desabilitado'"
            + "GROUP BY funcionario.id", nativeQuery = true)
    List<Manutencao> buscarManutencao(Long i);

}
