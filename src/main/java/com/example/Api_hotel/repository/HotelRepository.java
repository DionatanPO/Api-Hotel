package com.example.Api_hotel.repository;


import com.example.Api_hotel.model.Hotel;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

//    @Modifying
//    @Transactional
//    @Query(value = "SELECT * from Hotel where funcionario_id=?1 and estado !='Desabilitado'", nativeQuery = true)
//    List<Hotel> buscarHotels(Long i);

}
