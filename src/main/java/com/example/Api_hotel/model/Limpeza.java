package com.example.Api_hotel.model;



import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Limpeza {

    private Date data_limpeza;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    
    
    @OneToOne()
    @JoinColumn(name = "limpeza_id")
    private Apartamento apartamento;

    public Limpeza() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

  

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getData_limpeza() {
        return data_limpeza;
    }

    public void setData_limpeza(Date data_limpeza) {
        this.data_limpeza = data_limpeza;
    }

}
