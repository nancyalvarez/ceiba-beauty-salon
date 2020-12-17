package com.ceiba.servicioestetico.builder;

import com.ceiba.servicioestetico.modelo.entidad.ServicioEstetico;

public class ServicioEsteticoTestBuilder {
    private Long id;
    private String idServicio;
    private String nombre;
    private String tipoServicio;
    private int costo;
    private boolean estadoServicio;

    public ServicioEsteticoTestBuilder(){
        this.id = 1L;
        this.idServicio = "CA22";
        this.nombre = "cejas";
        this.tipoServicio = "Depilacion";
        this.costo = 7000;
        this.estadoServicio = true;
    }

    public ServicioEsteticoTestBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ServicioEsteticoTestBuilder setIdServicio(String idServicio){
        this.idServicio = idServicio;
        return this;
    }

    public ServicioEsteticoTestBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ServicioEsteticoTestBuilder setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
        return this;
    }

    public ServicioEsteticoTestBuilder setCosto(int costo) {
        this.costo = costo;
        return this;
    }

    public ServicioEsteticoTestBuilder setEstadoServicio(boolean estadoServicio) {
        this.estadoServicio = estadoServicio;
        return this;
    }

    public ServicioEstetico build(){
        return new ServicioEstetico(id, idServicio, nombre, tipoServicio, costo, estadoServicio);
    }
}
