/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Api_hotel.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dionatan
 */
@Service
public class TokenService {

    private static final long expirationTime = 1800000;
    private String key = "String aleatoria";
    

    public String genereteToken() {

        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject("Teste jwt api")
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    Claims decodeToken(String token) {
       return Jwts.parser()
               .setSigningKey(key)
               .parseClaimsJws(token)
               .getBody();
    }

}
