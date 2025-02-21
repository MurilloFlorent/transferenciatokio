package com.murillo.transferenciatokio.controller;


import com.murillo.transferenciatokio.business.services.TransferenciaService;
import com.murillo.transferenciatokio.dto.ErrorResponse;
import com.murillo.transferenciatokio.dto.TransferenciaDTO;
import com.murillo.transferenciatokio.dto.TransferenciaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/transferencia")
@CrossOrigin(value = "http://localhost:5173")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TransferenciaDTO transferenciaDTO) {
        try {
            TransferenciaResponseDTO transferenciaResponseDTO = transferenciaService.agendarTransferencia(transferenciaDTO);

            return ResponseEntity.ok(transferenciaResponseDTO);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        try {
            List<TransferenciaResponseDTO> transferenciaResponseDTO = transferenciaService.TodasTransferencias();

            return ResponseEntity.ok(transferenciaResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }

    }

}