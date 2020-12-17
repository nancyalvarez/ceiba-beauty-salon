package com.ceiba.servicioEstetico.comando.fabrica;

import com.ceiba.servicioEstetico.comando.ComandoServicioEstetico;
import com.ceiba.servicioEstetico.modelo.entidad.ServicioEstetico;
import org.springframework.stereotype.Component;

@Component
public class FabricaServicioEstetico {

    public ServicioEstetico crear(ComandoServicioEstetico comandoServicioEstetico){
        return new ServicioEstetico(
                comandoServicioEstetico.getId(),
                comandoServicioEstetico.getId_servicio(),
                comandoServicioEstetico.getNombre(),
                comandoServicioEstetico.getTipoServicioEstetico(),
                comandoServicioEstetico.getCosto(),
                comandoServicioEstetico.isEstadoServicioEstetico()
        );

    }
}
