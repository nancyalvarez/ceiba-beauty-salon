package com.ceiba.servicioEstetico.modelo.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServicioEsteticoDtoTest {

    @Test
    public void validarISServicioEsteticoRequerido(){
        //Arrange
        long id = 1L;
        String IS = "CC03";
        String nombre = "grafilado";
        String tipo = "Corte";
        int costo = 15000;
        boolean estado = true;
        //Act
        DtoServicioEstetico servicioEstetico = new DtoServicioEstetico(id, IS, nombre, tipo, costo, estado);
        //Assert
        boolean esValido = id == servicioEstetico.getId()&&IS.equals(servicioEstetico.getIS())
                &&nombre.equals(servicioEstetico.getNombre())&&tipo.equals(servicioEstetico.getTipo())
                &&costo == servicioEstetico.getCosto()&&estado==servicioEstetico.isEstado();
        assertTrue(esValido);

    }
}
