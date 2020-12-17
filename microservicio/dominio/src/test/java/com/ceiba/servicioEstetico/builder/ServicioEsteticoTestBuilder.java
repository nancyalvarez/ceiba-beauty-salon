package com.ceiba.servicioEstetico.builder;

import com.ceiba.servicioEstetico.modelo.entidad.ServicioEstetico;

public class ServicioEsteticoTestBuilder {
    private Long id;
    private String IS;
    private String nombre;
    private String tipo;
    private int costo;
    private boolean estado;

    public ServicioEsteticoTestBuilder(){
        this.id = 1L;
        this.IS = "CA22";
        this.nombre = "cejas";
        this.tipo = "Depilacion";
        this.costo = 7000;
        this.estado = true;
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

    public ServicioEsteticoTestBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public ServicioEsteticoTestBuilder setCosto(int costo) {
        this.costo = costo;
        return this;
    }

    public ServicioEsteticoTestBuilder setEstado(boolean estado) {
        this.estado = estado;
        return this;
    }

    public ServicioEstetico build(){
        return new ServicioEstetico(id, IS, nombre, tipo, costo, estado);
    }
}
