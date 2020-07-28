/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Api_hotel.controller;

import com.example.Api_hotel.model.Apartamento;
import com.example.Api_hotel.service.ApartamentoService;
import com.example.Api_hotel.exportar.ExcelFileExporter;
import com.example.Api_hotel.model.Hospedagem;
import com.example.Api_hotel.service.HospedagemService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dionatan
 */
@RestController
@RequestMapping(value = "/exporter/")
public class DownloadExcelController {

    @Autowired
    ApartamentoService apartamentoService;
    
     @Autowired
     HospedagemService hospedagemService;

    @GetMapping("/download/{id}")
    public void downloadCsv(@PathVariable Long id, HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=Relatório.xlsx");
     

        List<Apartamento> apartamentos = new ArrayList<>();
        List<Hospedagem> hospedagems = new ArrayList<>();

        try {
            apartamentos = apartamentoService.buscarEstado(id);
           hospedagems = hospedagemService.buscarEstadoAtivo();

        } catch (Exception e) {

        }

        ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(apartamentos,hospedagems);
        IOUtils.copy(stream, response.getOutputStream());
    }

}
