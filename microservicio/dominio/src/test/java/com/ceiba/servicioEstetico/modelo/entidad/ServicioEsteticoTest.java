package com.ceiba.servicioEstetico.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.servicioEstetico.builder.ServicioEsteticoTestBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.when;

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
        servicioEsteticoBuilder.setIS(null);
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
        servicioEsteticoBuilder.setTipo(null);
        //Act - Assert
        BasePrueba.assertThrows(servicioEsteticoBuilder::build, ExcepcionValorObligatorio.class, TIPO_SERVICIO_ESTETICO_REQUERIDO);
    }

    @Test
    public void validarTipoServicioEsteticoNoHabilitado(){
        //Arrange
        servicioEsteticoBuilder.setTipo("NO_EXISTE");
        //Act - Assert
        BasePrueba.assertThrows(servicioEsteticoBuilder::build, ExcepcionValorInvalido.class, TIPO_SERVICIO_ESTETICO_INVALIDO);
    }

    @Test
    public void validarCreacionModeloServicioEstetico(){

        //Arrange
        long id = 1L;
        String id_servicio = "TR03";
        String nombre = "semipermanente";
        String tipo = "Tinte";
        int costo = 120000;
        boolean estado = true;

        servicioEsteticoBuilder.setIS(id_servicio)
                .setNombre(nombre)
                .setTipo(tipo)
                .setCosto(costo)
                .setEstado(estado);

        //Act
        ServicioEstetico servicioEstetico = servicioEsteticoBuilder.build();
        //Assert
        boolean esValido= id_servicio.equals(servicioEstetico.getIdServicio()) && nombre.equals(servicioEstetico.getNombre())
                && tipo.equals(servicioEstetico.getTipoServicioEstetico()) && costo==servicioEstetico.getCosto()
                && estado == servicioEstetico.isEstadoServicioEstetico();


    }

}
