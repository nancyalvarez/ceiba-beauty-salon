package com.ceiba.servicioestetico.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.servicioestetico.builder.ServicioEsteticoTestBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ServicioEsteticoTest {

    private static final String ID_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el IS del servicio estético";
    private static final String NOMBRE_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el nombre del servicio estético";
    private static final String TIPO_SERVICIO_ESTETICO_REQUERIDO = "Se debe definir el tipo de servicio estético";
    private static final String TIPO_SERVICIO_ESTETICO_INVALIDO = "El tipo de servicio estético no corresponde";


    private ServicioEsteticoTestBuilder servicioEsteticoBuilder;

    @Before
    public void setUp(){
        servicioEsteticoBuilder = new ServicioEsteticoTestBuilder();
    }

    @Test
    public void validarIdServicioEsteticoRequerido(){
        //Arrange
        servicioEsteticoBuilder.setIdServicio(null);
        //Act - Assert
        BasePrueba.assertThrows(servicioEsteticoBuilder::build, ExcepcionValorObligatorio.class, ID_SERVICIO_ESTETICO_REQUERIDO);
    }

    @Test
    public void validarNombreServicioEsteticoRequerido(){
        //Arrange
        servicioEsteticoBuilder.setNombre(null);
        //Act - Assert
        BasePrueba.assertThrows(servicioEsteticoBuilder::build, ExcepcionValorObligatorio.class, NOMBRE_SERVICIO_ESTETICO_REQUERIDO);
    }

    @Test
    public void validarTipoServicioEsteticoRequerido(){
        //Arrange
        servicioEsteticoBuilder.setTipoServicio(null);
        //Act - Assert
        BasePrueba.assertThrows(servicioEsteticoBuilder::build, ExcepcionValorObligatorio.class, TIPO_SERVICIO_ESTETICO_REQUERIDO);
    }

    @Test
    public void validarTipoServicioEsteticoNoHabilitado(){
        //Arrange
        servicioEsteticoBuilder.setTipoServicio("NO_EXISTE");
        //Act - Assert
        BasePrueba.assertThrows(servicioEsteticoBuilder::build, ExcepcionValorInvalido.class, TIPO_SERVICIO_ESTETICO_INVALIDO);
    }

    @Test
    public void validarCreacionModeloServicioEstetico(){

        //Arrange
        long id = 1L;
        String idServicio = "TR03";
        String nombre = "semipermanente";
        String tipoServicio = "Tinte";
        int costo = 120000;
        boolean estadoServicio = true;

        servicioEsteticoBuilder.setIdServicio(idServicio)
                .setNombre(nombre)
                .setTipoServicio(tipoServicio)
                .setCosto(costo)
                .setEstadoServicio(estadoServicio);

        //Act
        ServicioEstetico servicioEstetico = servicioEsteticoBuilder.build();
        //Assert
        boolean esValido= id==servicioEstetico.getId() && idServicio.equals(servicioEstetico.getIdServicio()) && nombre.equals(servicioEstetico.getNombre())
                && tipoServicio.equals(servicioEstetico.getTipoServicio()) && costo==servicioEstetico.getCosto()
                && estadoServicio == servicioEstetico.isEstadoServicio();
        assertTrue(esValido);

    }

}
