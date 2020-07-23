package com.example.Api_hotel.service;

import com.example.Api_hotel.model.Funcionario;
import com.example.Api_hotel.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Funcionario salvar(Funcionario funcionario) {
        //validações e etcS
        return funcionarioRepository.save(funcionario);
    }

    public void delete(Funcionario funcionario) {

        funcionarioRepository.delete(funcionario);
    }

    public Funcionario buscaPorID(Long id) throws Exception {
        return funcionarioRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return funcionarioRepository.findAll();
    }

    public List buscarNome(Funcionario funcionario) {
        return funcionarioRepository.findByNomeContaining(funcionario.getNome());
    }

    public List buscarEstadoAtivo(Funcionario f) {
        Long i = f.getAdministrador_id();
        String estado = "Abilitado";
        return funcionarioRepository.findFuncionarioByEstadoAndAdministrador(estado, i);

    }

    public Funcionario buscaPorCodiidentificacao(String codidentificacao) throws Exception {
        return funcionarioRepository.findByCodidentificacao(codidentificacao);
    }
}
