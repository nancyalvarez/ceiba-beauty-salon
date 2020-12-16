package com.ceiba.servicioEstetico.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.servicioEstetico.builder.ServicioEsteticoTestBuilder;
import org.junit.Before;
import org.junit.Test;

public class ServicioEsteticoTest {

    private static final String IS_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el IS del servicio estético";
    private static final String NOMBRE_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el nombre del servicio estético";
    private static final String TIPO_SERVICIO_ESTETICO_REQUERIDO = "Se debe definir el tipo de servicio estético";
    private static final String TIPO_SERVICIO_ESTETICO_INVALIDO = "El tipo de servicio estético no corresponde";
    private static final String COSTO_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el costo del servicio estetico";

    private ServicioEsteticoTestBuilder servicioEsteticoBuilder;

    @Before
    public void setUp(){
        servicioEsteticoBuilder = new ServicioEsteticoTestBuilder();
    }

    @Test
    public void validarISServicioEsteticoRequerido(){
        //Arrange
        servicioEsteticoBuilder.setIS(null);
        //Act - Assert
        BasePrueba.assertThrows(servicioEsteticoBuilder::build, ExcepcionValorObligatorio.class, IS_SERVICIO_ESTETICO_REQUERIDO);
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
        servicioEsteticoBuilder.setTipoServicioEstetico(null);
        //Act - Assert
        BasePrueba.assertThrows(servicioEsteticoBuilder::build, ExcepcionValorObligatorio.class, TIPO_SERVICIO_ESTETICO_REQUERIDO);
    }

    @Test
    public void validarTipoServicioEsteticoNoHabilitado(){
        //Arrange
        servicioEsteticoBuilder.setTipoServicioEstetico("NO_EXISTE");
        //Act - Assert
        BasePrueba.assertThrows(servicioEsteticoBuilder::build, ExcepcionValorInvalido.class, TIPO_SERVICIO_ESTETICO_INVALIDO);
    }

    @Test
    public void validarCostoservicioEsteticoRequerido(){
        //Arrange
        servicioEsteticoBuilder.setCosto(0);
        //Act - Assert
        BasePrueba.assertThrows(servicioEsteticoBuilder::build, ExcepcionValorObligatorio.class, COSTO_SERVICIO_ESTETICO_REQUERIDO);
    }

    @Test
    public void validarCreacionModeloServicioEstetico(){

        //Arrange
        long id = 1L;
        String IS = "TR03";
        String nombre = "semipermanente";
        String tipoServicioEstetico = "Tinte";
        int costo = 120000;
        boolean estadoServicioEstetico = true;

        servicioEsteticoBuilder.setIS(IS).setNombre(nombre)
            .setTipoServicioEstetico(tipoServicioEstetico)
            .setCosto(costo).setEstadoServicioEstetico(estadoServicioEstetico);

        //Act
        ServicioEstetico servicioEstetico = servicioEsteticoBuilder.build();
        //Assert
        boolean esValido= IS.equals(servicioEstetico.getIS()) && nombre.equals(servicioEstetico.getNombre())
                && tipoServicioEstetico.equals(servicioEstetico.getTipoServicioEstetico()) && costo==servicioEstetico.getCosto()
                && estadoServicioEstetico == servicioEstetico.isEstadoServicioEstetico();


    }

}
