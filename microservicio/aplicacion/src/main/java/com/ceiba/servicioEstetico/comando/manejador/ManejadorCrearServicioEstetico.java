package com.ceiba.servicioEstetico.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.servicioEstetico.comando.ComandoServicioEstetico;
import com.ceiba.servicioEstetico.comando.fabrica.FabricaServicioEstetico;
import com.ceiba.servicioEstetico.modelo.entidad.ServicioEstetico;
import com.ceiba.servicioEstetico.servicio.ServicioCrearServicioEstetico;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearServicioEstetico implements ManejadorComandoRespuesta<ComandoServicioEstetico, ComandoRespuesta<Long>> {

    private final FabricaServicioEstetico fabricaServicioEstetico;
    private final ServicioCrearServicioEstetico servicioCrearServicioEstetico;

    public ManejadorCrearServicioEstetico(FabricaServicioEstetico fabricaServicioEstetico,
                                          ServicioCrearServicioEstetico servicioCrearServicioEstetico){
        this.fabricaServicioEstetico = fabricaServicioEstetico;
        this.servicioCrearServicioEstetico =  servicioCrearServicioEstetico;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoServicioEstetico comandoServicioEstetico) {
        ServicioEstetico servicioEstetico = this.fabricaServicioEstetico.crear(comandoServicioEstetico);
        return new ComandoRespuesta<>(this.servicioCrearServicioEstetico.ejecutar(servicioEstetico));
    }
}
