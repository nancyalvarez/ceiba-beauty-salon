package com.ceiba.servicioEstetico.builder;

import com.ceiba.servicioEstetico.modelo.entidad.ServicioEstetico;

public class ServicioEsteticoTestBuilder {
    private Long id;
    private String IS;
    private String nombre;
    private String tipoServicioEstetico;
    private int costo;
    private boolean estadoServicioEstetico;

    public ServicioEsteticoTestBuilder(){
        this.id = 1L;
        this.IS = "CA22";
        this.nombre = "cejas";
        this.tipoServicioEstetico = "Depilacion";
        this.costo = 7000;
        this.estadoServicioEstetico = true;
    }

    public ServicioEsteticoTestBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ServicioEsteticoTestBuilder setIS(String IS){
        this.IS = IS;
        return this;
    }

    public ServicioEsteticoTestBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ServicioEsteticoTestBuilder setTipoServicioEstetico(String tipoServicioEstetico) {
        this.tipoServicioEstetico = tipoServicioEstetico;
        return this;
    }

    public ServicioEsteticoTestBuilder setCosto(int costo) {
        this.costo = costo;
        return this;
    }

    public ServicioEsteticoTestBuilder setEstadoServicioEstetico(boolean estadoServicioEstetico) {
        this.estadoServicioEstetico = estadoServicioEstetico;
        return this;
    }

    public ServicioEstetico build(){
        return new ServicioEstetico(id, IS, nombre, tipoServicioEstetico, costo, estadoServicioEstetico);
    }
}
