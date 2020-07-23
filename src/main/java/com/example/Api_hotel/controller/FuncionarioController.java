package com.example.Api_hotel.controller;

import com.example.Api_hotel.model.Funcionario;
import com.example.Api_hotel.model.Usuario;
import com.example.Api_hotel.service.AuthenticateService;
import com.example.Api_hotel.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario/")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    AuthenticateService authenticateService;

    @PostMapping()
    public ResponseEntity<Funcionario> cadastrar(@RequestBody Funcionario fum) {

        Funcionario funcionarioSalvo = funcionarioService.salvar(fum);

        return new ResponseEntity<>(funcionarioSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Funcionario> editar(@RequestBody Funcionario fum) throws Exception {
        if (fum.getSenha().equals("")) {
            Funcionario f2 = funcionarioService.buscaPorID(fum.getId());
            fum.setSenha(f2.getSenha());
        }
        Funcionario funcionarioSalvo = funcionarioService.salvar(fum);

        return ResponseEntity.ok(funcionarioSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Funcionario fum = new Funcionario();
        fum.setId(id);
        funcionarioService.delete(fum);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Funcionario>> mostrarTodos() {

        List funcionarioList = funcionarioService.buscarTodos();

        return new ResponseEntity<>(funcionarioList, HttpStatus.OK);
    }

    @GetMapping(value = "todosAtivos/{id}")
    public ResponseEntity<List<Funcionario>> mostrarTodosAtivos(@PathVariable Long id) {
        Funcionario f = new Funcionario();
        f.setAdministrador_id(id);

        List funcionarios = funcionarioService.buscarEstadoAtivo(f);
        System.out.println(funcionarios.size());
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Funcionario> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(funcionarioService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "nome/")
    @ResponseBody
    public ResponseEntity<List<Funcionario>> buscaNome(@RequestParam String nome) {
        Funcionario fum = new Funcionario();
        fum.setNome(nome);
        List funcionarioList = funcionarioService.buscarNome(fum);

        return new ResponseEntity<>(funcionarioList, HttpStatus.OK);
    }

    @PostMapping(value = "login")
    public ResponseEntity<Funcionario> buscaCodidentificacao(@RequestBody Funcionario funcionario) {
        Funcionario f;
        f = Usuario.funcionarioTouser(authenticateService.authenticate(funcionario), "Bearer");
        if (f != null) {
            f.setSenha("");
        }
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

}
