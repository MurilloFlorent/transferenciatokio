package com.murillo.transferenciatokio.controller;


import com.murillo.transferenciatokio.business.services.TransferenciaService;
import com.murillo.transferenciatokio.controller.dto.TransferenciaDTO;
import com.murillo.transferenciatokio.controller.dto.TransferenciaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/transferencia")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping
    public ResponseEntity<TransferenciaResponseDTO> create(@RequestBody TransferenciaDTO transferenciaDTO) {

        return ResponseEntity.ok(transferenciaService.agendarTransferencia(transferenciaDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransferenciaResponseDTO>> getAll() {
        return ResponseEntity.ok(transferenciaService.TodasTransferencias());
    }

}