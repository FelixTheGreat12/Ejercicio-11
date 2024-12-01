package com.upiiz.securitydatabase.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/facturas")
public class FacturaController {

    @GetMapping("/listar")
    public String listarFacturas() {
        return "Listado de Facturas";
    }

    @PostMapping("/crear")
    public String crearFactura() {
        return "Creando Factura";
    }

    @PutMapping("/actualizar")
    public String actualizarFactura() {
        return "Actualizando factura";
    }

    @DeleteMapping("/eliminar")
    public String eliminarFactura() {
        return "Eliminando una Factura";
    }

}