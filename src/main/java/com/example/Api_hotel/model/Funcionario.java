package com.example.Api_hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private String cpf;
    private String nome;

    private String codidentificacao;
    private String senha;
    private String cargo;
    private String token;
    private Long administrador_id;

    @OneToOne()
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Funcionario() {
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

 

    public Long getAdministrador_id() {
        return administrador_id;
    }

    public void setAdministrador_id(Long administrador_id) {
        this.administrador_id = administrador_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodidentificacao() {
        return codidentificacao;
    }

    public void setCodidentificacao(String codidentificacao) {
        this.codidentificacao = codidentificacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{"
                + "nome='" + nome + '\''
                + '}';
    }
}
