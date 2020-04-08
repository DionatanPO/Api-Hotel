package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Funcionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByNomeContaining(String nome);

    List<Funcionario> findByEstadoNot(String estado);

}
