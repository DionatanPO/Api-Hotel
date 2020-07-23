/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Api_hotel.model;

/**
 *
 * @author Dionatan
 */
public class Usuario {

    private String nome;
    private String tipo;
    private String nome_propriedade;
    private String token;

    public Usuario(String nome, String tipo, String nome_propriedade, String token) {
        this.nome = nome;
        this.tipo = tipo;
        this.nome_propriedade = nome_propriedade;
        this.token = token;
    }

    public Usuario() {
    }

    public static Funcionario funcionarioTouser(Funcionario funcionario, String tipo) {


        if (funcionario.getToken() == null ||funcionario.getToken() == "") {
            funcionario.setSenha("");
            return null;
        } else {

            return funcionario;
        }

    }
}
