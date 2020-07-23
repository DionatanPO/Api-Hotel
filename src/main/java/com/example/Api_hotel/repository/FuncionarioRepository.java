package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Funcionario;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM Funcionario f WHERE f.estado=?1 AND f.administrador_id=?2", nativeQuery = true)
    List<Funcionario> findFuncionarioByEstadoAndAdministrador(String estado, Long i);

    List<Funcionario> findByNomeContaining(String nome);

    List<Funcionario> findByEstadoNot(String estado);

    Funcionario findByCodidentificacao(String codidentificacao);

}
