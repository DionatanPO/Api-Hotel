/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Api_hotel.service;

import com.example.Api_hotel.model.Funcionario;

import io.jsonwebtoken.Claims;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dionatan
 */
@Service
public class AuthenticateService {

    private FuncionarioService funcionarioService;
    private TokenService tokenService;

    @Autowired
    public AuthenticateService( FuncionarioService funcionarioService, TokenService tokenService) {
     
        this.funcionarioService = funcionarioService;
        this.tokenService = tokenService;
    }

    public Funcionario authenticate(Funcionario f) {
        Funcionario funcionario = new Funcionario();
        try {
           funcionario = funcionarioService.buscaPorCodiidentificacao(f.getCodidentificacao());
        } catch (Exception e) {
                System.out.println(e);
          
        }

        if (f.getSenha().equals(funcionario.getSenha())) {
            String tokenGerado = tokenService.genereteToken();
            funcionario.setToken(tokenGerado);
            return funcionario;
        } else {
            return f;
        }

    }

    private boolean validarToken(String token) {
        try {
            String tokenValidado = token.replace("Bearer", "");
            Claims claims = tokenService.decodeToken(tokenValidado);
            System.out.println(claims.getIssuer());
            System.out.println(claims.getIssuedAt());
            //verificar se o token esta expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) {
                System.out.println(claims.getExpiration());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Token expirado");
            return false;
        }

    }

}
