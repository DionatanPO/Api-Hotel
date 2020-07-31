package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Hospedagem;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {

    List<Hospedagem> findByEstadoNot(String estado);

    @Modifying
    @Transactional
    @Query(value = "SELECT * from Hospedagem INNER JOIN Funcionario ON  Funcionario.administrador_id=?1 AND Hospedagem.estado!='Desabilitado' "
            + "AND Hospedagem.estado!='Concluido' AND funcionario.id = hospedagem.funcionario_id", nativeQuery = true)
    List<Hospedagem> buscarHospedagem(Long i);

     @Modifying
    @Transactional
    @Query(value = "SELECT * from Hospedagem INNER JOIN Funcionario ON  Funcionario.administrador_id=?1 AND Hospedagem.estado!='Desabilitado' "
            + " AND Hospedagem.estado!='Concluido' AND funcionario.id = hospedagem.funcionario_id"
            + " AND Hospedagem.data_entrada BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Hospedagem> buscarHospedagemEntreDatas(Long i, String d1, String d2);
}
