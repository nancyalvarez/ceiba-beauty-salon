package com.ceiba.servicioEstetico.controlador;

import com.ceiba.servicioEstetico.consulta.ManejadorListarServicioEstetico;
import com.ceiba.servicioEstetico.modelo.dto.DtoServicioEstetico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("/servicios_esteticos")
@Api(tags = {"Controlador consulta de servicios esteticos"})
public class ConsultaControladorServicioEstetico {
    private final ManejadorListarServicioEstetico manejadorListarServicioEstetico;

    public ConsultaControladorServicioEstetico(ManejadorListarServicioEstetico manejadorListarServicioEstetico){
        this.manejadorListarServicioEstetico = manejadorListarServicioEstetico;
    }

    @GetMapping
    @ApiOperation("Listar servicios esteticos")
    public List<DtoServicioEstetico> listar(){
        return this.manejadorListarServicioEstetico.ejecutar();
    }
}
