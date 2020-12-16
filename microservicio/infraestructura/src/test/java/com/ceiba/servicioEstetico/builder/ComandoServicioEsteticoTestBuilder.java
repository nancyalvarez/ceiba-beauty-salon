package com.ceiba.servicioEstetico.builder;

import com.ceiba.servicioEstetico.comando.ComandoServicioEstetico;

public class ComandoServicioEsteticoTestBuilder {

    private Long id;
    private String IS;
    private String nombre;
    private String tipoServicioEstetico;
    private int costo;
    private boolean estadoServicioEstetico;

    public ComandoServicioEsteticoTestBuilder(){
        this.IS = "DS21";
        this.nombre = "Cejas";
        this.tipoServicioEstetico="Depilacion";
        this.costo = 8000;
        this.estadoServicioEstetico=true;
    }

    public ComandoServicioEsteticoTestBuilder setId(Long id){
        this.id = id;
        return this;
    }

    public ComandoServicioEsteticoTestBuilder setIS(String IS){
        this.IS = IS;
        return this;
    }

    public ComandoServicioEsteticoTestBuilder setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ComandoServicioEsteticoTestBuilder setTipoServicioEstetico(String tipoServicioEstetico){
        this.tipoServicioEstetico = tipoServicioEstetico;
        return this;
    }

    public ComandoServicioEsteticoTestBuilder setCosto(int costo){
        this.costo = costo;
        return this;
    }

    public ComandoServicioEsteticoTestBuilder setEstadoServicioEstetico(boolean estadoServicioEstetico){
        this.estadoServicioEstetico = estadoServicioEstetico;
        return this;
    }

    public ComandoServicioEstetico build(){
        return new ComandoServicioEstetico(
                id, IS, nombre, tipoServicioEstetico, costo, estadoServicioEstetico
        );
    }

}
