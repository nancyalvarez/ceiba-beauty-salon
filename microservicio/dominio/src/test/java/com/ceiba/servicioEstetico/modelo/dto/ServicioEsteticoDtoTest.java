package com.ceiba.servicioEstetico.modelo.dto;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ServicioEsteticoDtoTest {

    @Test
    public void validarISServicioEsteticoRequerido(){
        //Arrange
        long id = 1L;
        String IS = "CC03";
        String nombre = "grafilado";
        String tipoServicioEstetico = "Corte";
        int costo = 15000;
        boolean estadoServicioEstetico = true;
        //Act
        DtoServicioEstetico servicioEstetico = new DtoServicioEstetico(id, IS, nombre, tipoServicioEstetico, costo, estadoServicioEstetico);
        //Assert
        boolean esValido = id == servicioEstetico.getId()&&IS.equals(servicioEstetico.getIS())
                &&nombre.equals(servicioEstetico.getNombre())&&tipoServicioEstetico.equals(servicioEstetico.getTipoServicioEstetico())
                &&costo == servicioEstetico.getCosto()&&estadoServicioEstetico==servicioEstetico.isEstadoServicioEstetico();
        assertTrue(esValido);

    }
}
