package com.ceiba.servicioEstetico.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.servicioEstetico.comando.ComandoServicioEstetico;
import com.ceiba.servicioEstetico.comando.manejador.ManejadorCrearServicioEstetico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RestControllerAdvice
@RequestMapping("/servicios_esteticos")
@Api(tags = {"Controlador comando de servicios esteticos"})
public class ComandoControladorServicioEstetico {

    private final ManejadorCrearServicioEstetico manejadorCrearServicioEstetico;

    @Autowired
    public ComandoControladorServicioEstetico(ManejadorCrearServicioEstetico manejadorCrearServicioEstetico){
        this.manejadorCrearServicioEstetico = manejadorCrearServicioEstetico;
    }

    @PostMapping
    @ApiOperation("Crear un servicio estético")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoServicioEstetico comandoServicioEstetico){
        return manejadorCrearServicioEstetico.ejecutar(comandoServicioEstetico);
    }
}
