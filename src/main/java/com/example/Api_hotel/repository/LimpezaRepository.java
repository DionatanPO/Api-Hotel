package com.example.Api_hotel.repository;

import com.example.Api_hotel.model.Limpeza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimpezaRepository extends JpaRepository<Limpeza, Long> {



}
